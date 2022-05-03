package com.mahmoudbashir.daggerhiltexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudbashir.daggerhiltexample.R
import com.mahmoudbashir.daggerhiltexample.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var main_adapter: MainAdapter
    lateinit var recView: RecyclerView
    lateinit var proBar : ProgressBar
    private val mainViewModel: MainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpUI()
        setUpObservingOnData()
    }

    private fun setUpObservingOnData() {
        mainViewModel.users.observe(this,{
            when(it.status){
                Status.SUCCESS -> {
                    proBar.visibility = View.GONE
                    it.data.let { mlist -> main_adapter.updateDataList(mlist!!) }
                    recView.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    proBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    proBar.visibility = View.VISIBLE
                    recView.visibility = View.GONE
                }
            }
        })
    }

    private fun setUpUI() {

        recView = findViewById(R.id.recyclerView)
        proBar = findViewById(R.id.progressBar)

        main_adapter = MainAdapter(arrayListOf())

        recView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )
            adapter = main_adapter
        }
    }


}