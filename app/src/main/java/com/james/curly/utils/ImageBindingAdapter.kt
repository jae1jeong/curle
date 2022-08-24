package com.james.curly.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object ImageBindingAdapter {

    @BindingAdapter("app:imageUrl")
    @JvmStatic fun loadImage(imageView: ImageView, url: String?) {
        url?.let {
            Glide.with(imageView.context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(RequestOptions().centerCrop())
                .into(imageView)
        }

    }
}