package com.example.sampletokenize.ui.base

import androidx.appcompat.app.AppCompatActivity

// TODO move rq to request codes file, make file
const val RQ_PAYMENT_DATA = 0

abstract class BaseActivity : AppCompatActivity() {

    abstract val commonActivityBindings: BaseActivityBinding

//    override fun onActivityResult(requestCode:Int){
//        if(RQ_PAYMENT_DATA == requestCode){
//            val a = "a"
//            //TODO
//        }
//    }
}
