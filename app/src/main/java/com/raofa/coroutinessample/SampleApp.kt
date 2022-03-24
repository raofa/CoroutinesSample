package com.raofa.coroutinessample

import android.app.Application
import android.content.Context
import org.litepal.LitePal

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/10/30 14:55
 * @description:
 */
class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        mContext = this
    }
    
    companion object{
        lateinit var mContext : Context
        const val TOKEN = "zVtEh5YYSqkYHgLq"
    }

    private fun mainTest(){
        //by main
        //test
    }
    

    private fun test(){

    }

    private fun rebaseTest1(){

    }

    private fun rebaseTest2(){

    }

}