package com.zk.gracefulexitapp.one;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zk.gracefulexitapp.R;

public class OneActivity extends BaseActivity {
    private static final String TAG = "OneActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //发送退出指令
        RxBus.getInstance().post(new NormalEvent(-1));

    }

    public void addFisnsh(View view) {
        Intent intent = new Intent(OneActivity.this, GoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "关闭了？");
    }

}
