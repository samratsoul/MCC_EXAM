package com.mcc.q1_gallary_project;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.mcc.q1_gallary_project.ImageView.TouchImageView;

import java.io.File;

public class ImageViewActivity extends AppCompatActivity {

    TouchImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        String imagePath= getIntent().getStringExtra(Constant.IMAGE_SRC);
        imageView= new TouchImageView(this);

        Glide.with(this)
                .load(new File(imagePath))
                .placeholder(R.drawable.ic_launcher_background)
                .skipMemoryCache(false)
                .into(imageView);



    }
}
