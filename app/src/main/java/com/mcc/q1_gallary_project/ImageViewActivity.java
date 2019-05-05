package com.mcc.q1_gallary_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.mcc.q1_gallary_project.ImageView.TouchImageView;

public class ImageViewActivity extends AppCompatActivity {

    TouchImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        String imagePath= getIntent().getStringExtra(Constant.IMAGE_SRC);
        imageView= new TouchImageView(this);
        Glide.with(this)
                .load(imagePath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);

    }
}
