package com.mahmoudbashir.daggerhiltexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.mahmoudbashir.daggerhiltexample.R
import com.mahmoudbashir.daggerhiltexample.data.model.UserLocalModel
import com.mahmoudbashir.daggerhiltexample.databinding.ActivityMainLocalDataBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainLocalDataActivity : AppCompatActivity() {
    lateinit var localBinding:ActivityMainLocalDataBinding
    private val viewModel:LocalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_local_data)

        localBinding.insertBtn.setOnClickListener {
            viewModel.insertUserData(UserLocalModel(0,"Mahmoud",25,"Egyptian"))
        }

        localBinding.getBtn.setOnClickListener {
            viewModel.getAllData()
            viewModel.allData.observe(this,{
                mlist->
                if (mlist != null){
                    for (elem in mlist){
                        Toast.makeText(this," id : ${elem.id} , name : ${elem.name} , age : ${elem.age} , nationality : ${elem.nationality}",
                            Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this,"there is no data inserted !!",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}