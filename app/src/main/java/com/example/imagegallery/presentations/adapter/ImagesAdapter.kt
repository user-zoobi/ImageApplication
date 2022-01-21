package com.example.imagegallery.presentations.adapter

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImagesAdapter : BaseObservable() {

    @BindingAdapter("imageFromUrl")
    @JvmStatic
    fun imageFromUrl(imageView: ImageView, imageUrl:String?){
        if (!imageUrl.isNullOrEmpty()){
            Glide.with(imageView.context).load(imageUrl).into(imageView)
        }
    }

    @BindingAdapter("circularImageFromUrl")
    @JvmStatic
    fun circularImageFromUrl(circleImageView: ImageView, imageUrl:String){
        if (!imageUrl.isNullOrEmpty()){
            Glide.with(circleImageView.context).load(imageUrl).into(circleImageView)
        }
    }
}