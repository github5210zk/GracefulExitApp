package com.zk.gracefulexitapp.one;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zk.gracefulexitapp.R;

/**
 * Created by ${zk} on 2018/4/6 0006.
 * 欢迎每一天
 */

public class GoActivity extends BaseActivity {
    private static final String TAG = "GoActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);
        Intent intent = new Intent(GoActivity.this, OneActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "关闭了？");
    }
}
