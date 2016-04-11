package com.example.administrator.android7thclass;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** 7주차
     * Day11-04 영상
     *
     * 1. 안드로이드의 이벤트 처리
     * ACTION_DOWN >> onClick >> ACTION_UP 순서 기억
     *
     * 2. 커스텀 뷰 (생략)
     *
     * 3. GestureDeector!!! <<<
     *
     * 4. Manifest 에서의 configChange (화면전환)
     *  >>  onConfigurationChanged()
     *
     * Day12-01 영상
     *
     * 1. WebView
     *
     * 2. Animation !!
     *
     *
     * Day14-02 영상
     * 3. Menu / ActionBar / ToolBar
     *
     *
     *
     */

    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        Button btn = (Button)findViewById(R.id.button);

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        textView.setText("손가락이 눌려졌습니다.");
                        break;

                    case MotionEvent.ACTION_UP:
                        textView.setText("손가락이 떼졌습니다.");
                        break;
                }

                return false;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("버튼이 클릭되었습니다.");
            }
        });


        // 3. GestureDetector
        detector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textView.setText("onScroll 호출됨 : (" + distanceX +","+distanceY+")");

                return super.onScroll(e1, e2, distanceX, distanceY);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                textView.setText("onFling 호출됨 : (" + velocityX +","+velocityY+")");

                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });


        // 다음 예제 (Webview)
        btn = (Button)findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        // 다음 예제 (Animation)
        btn = (Button)findViewById(R.id.btn_ani);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
            }
        });
        // 다음 예제 (ActionBar)
        btn = (Button)findViewById(R.id.btn_actionbar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActionBarActivity.class));
            }
        });
    }

    // 터치 이벤트를 OVERRIDE
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (detector != null) {
            return detector.onTouchEvent(event);
        }
        else {
            return super.onTouchEvent(event);
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, "Back key Pressed", Toast.LENGTH_SHORT).show();
        // finish();
        return;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (event.getAction()) {
            case KeyEvent.KEYCODE_BACK :
                Toast.makeText(MainActivity.this, "Back Key Down", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onKeyDown(keyCode, event);
    }


    // 4. 화면전환
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(MainActivity.this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(MainActivity.this, "PORTRAIT", Toast.LENGTH_SHORT).show();
        }

    }
}
