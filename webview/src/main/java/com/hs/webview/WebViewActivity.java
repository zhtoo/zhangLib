package com.hs.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zhanghaitao on 2017/5/1.
 */

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webapp_test);
        Button button = (Button) findViewById(R.id.webview_bt);
        //设置编码  
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        //支持js  
        webView.getSettings().setJavaScriptEnabled(true);
        //设置背景颜色 透明  
        webView.setBackgroundColor(Color.argb(0, 0, 0, 0));
        //设置本地调用对象及其接口 
        JavaScriptObject javaScriptObject = new JavaScriptObject(this);
        //添加js的接口
        webView.addJavascriptInterface(javaScriptObject, "myObj");
        //载入本地js  
       // webView.loadUrl("file:///android_asset/test.html");
        //载入网络端js  
         webView.loadUrl("http://10.0.2.2:8080/test.html");
        //点击调用js中方法  
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.webview_bt) {
            String str = "我是来自As的参数";
            webView.loadUrl("javascript:funFromjs('" + str + "')");
        }
    }

    /**
     * 方法名称和js的不能一样
     * 对象名称必须一样  即 创建的对象 myObj
     * 和html 调用的对象 myObj 要保持一致
     */
    public class JavaScriptObject {
        Context mContxt;

        public JavaScriptObject(Context mContxt) {
            this.mContxt = mContxt;
        }

        @JavascriptInterface
        public void funfromAndroid(String name) {
            Toast.makeText(mContxt, name, Toast.LENGTH_LONG).show();
        }

        @JavascriptInterface
        public void funToMain() {
            Intent intent = new Intent(mContxt, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
