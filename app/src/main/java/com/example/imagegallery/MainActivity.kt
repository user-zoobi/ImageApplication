package com.example.imagegallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.imagegallery.extensions.gotoActivity
import com.example.imagegallery.presentations.BaseActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        splash()
    }

    fun splash(){
        Handler().postDelayed({
            gotoActivity(BaseActivity::class.java)
            finish()
        }, 3000L)
    }
}