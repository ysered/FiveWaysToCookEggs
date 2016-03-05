package com.example.android.fivewaystocookeggs;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class DataBindingAdapters {

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

}
