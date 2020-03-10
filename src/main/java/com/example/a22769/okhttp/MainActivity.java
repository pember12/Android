package com.example.a22769.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity  {


    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        InitOkhttp();

    }

    private void InitOkhttp() {

        /**
         * 创建一个Okhttp对象
         */
        OkHttpClient client = new OkHttpClient();
        /**
         * 发起一个请求需要创建Request对象
         */
        Request request = new Request.Builder().url("http://www.baidu.com").build();

        try {
            /**
             * newCall方法（参数为Request对象）
             * 创建一个Response对象 ，调用execute方法来获取服务器返回的数据
             */
            Response response = client.newCall(request).execute();
            /**
             * 把得到的数据储存
             */
            String responseData = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
