package com.raofa.coroutinessample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raofa.coroutinessample.R
import com.raofa.coroutinessample.ui.area.ChooseAreaFragment

class MainActivity : AppCompatActivity() {
    
    private val TAG = "MainActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        supportFragmentManager.beginTransaction().replace(R.id.container,ChooseAreaFragment()).commit()
    }

}
