package com.example.timteam.youwillwin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageFullActivity extends AppCompatActivity {
    ImageView fullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full);
        fullscreen=findViewById(R.id.full_screen_image);
    }
}
