package com.example.administrator.android7thclass;

import android.graphics.Interpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnimationActivity extends AppCompatActivity {

    TextView textView;
    Button startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        textView = (TextView)findViewById(R.id.textView);
        startBtn = (Button)findViewById(R.id.btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                Animation translate = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.translate);
                translate.setInterpolator(new BounceInterpolator());
                textView.startAnimation(translate);
            }
        });





    }
}
