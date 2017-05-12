package com.bawei.cql0510;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.okhttpdemo.MyOkHttp;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button butget;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            Toast.makeText(Main2Activity.this, str, Toast.LENGTH_SHORT).show();
        }
    };
    private Button butpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        butget = (Button) findViewById(R.id.butget);

        butget.setOnClickListener(this);
        butpost = (Button) findViewById(R.id.butpost);
        butpost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butget:
                MyOkHttp.AsynGet(handler);
                break;
            case R.id.butpost:
                MyOkHttp.AsynPost(handler);
                break;
        }
    }
}
