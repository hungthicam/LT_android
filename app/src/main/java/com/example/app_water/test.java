package com.example.app_water;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class test extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView hydrationText;
    private TextView goalText;
    private Button btnSmall, btnLarge;
    private int hydration = 0; // initial hydration in ml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        progressBar = findViewById(R.id.progressBar);
        hydrationText = findViewById(R.id.hydration_text);
        goalText = findViewById(R.id.goal_text);
        btnSmall = findViewById(R.id.btn_small);
        btnLarge = findViewById(R.id.btn_large);

        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWater(500); // 500 ml
            }
        });

        btnLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWater(1000);
            }
        });

        VideoView videoView = findViewById(R.id.home_test);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nuoc);
        videoView.setVideoURI(videoUri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();

    }

    private void addWater(int amount) {
        hydration += amount;
        int progress = hydration / 20;
        progressBar.setProgress(progress);
        hydrationText.setText(hydration + " ml");
        goalText.setText("You have achieved\n" + (progress) + "% of your goal today");
    }

    private void water(int amount) {
        hydration -= amount;
        int progress = hydration / 30; // Assuming goal is 3000 ml
        progressBar.setProgress(progress);
        hydrationText.setText(hydration + " ml");
        goalText.setText("You have achieved\n" + (progress) + "% of your goal today");
    }
}
