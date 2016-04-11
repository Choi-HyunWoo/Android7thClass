package com.example.administrator.android7thclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText urlEditView;
    Button okButton;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // View initialize
        urlEditView = (EditText)findViewById(R.id.edit_url);
        okButton = (Button)findViewById(R.id.btn_ok);
        webView = (WebView)findViewById(R.id.webView);

        // WebView setting
        webView.getSettings().setJavaScriptEnabled(true);           // 동적 페이지를 위해 자바스크립트가 동작해야함!

        //
        webView.setWebViewClient(new WebViewClient() {              // 이 작업을 안해줄 시 브라우저를 통해 웹을 실행
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });



        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(urlEditView.getText().toString());
            }
        });



    }
}
