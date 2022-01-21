package com.example.imagegallery.extensions

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.gotoActivity(
    activity:Class<*>
){
    val intent = Intent(this, activity)
    startActivity(intent)
}

fun AppCompatActivity.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}




