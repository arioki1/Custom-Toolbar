package com.arioki.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arioki.customtoolbar.CustomToolbar
import com.arioki.customtoolbar.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(customToolbar)
        customToolbar.setTitle("Simple Custom Toolbar")
        customToolbar.setOnClickListener(object : CustomToolbar.OnCustomToolbarListener {
            override fun onClickButtonLeft() {
                "Click Left Button".toast(baseContext)
            }

            override fun onClickButtonRight() {
                "Click Right Button".toast(baseContext)
            }
        })
    }
}