package com.zk.gracefulexitapp.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by ${zk} on 2018/4/6 0006.
 * 欢迎每一天
 */

public class BaseActivity extends AppCompatActivity {
    Subscription mSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRxBus();
    }

    //接受退出的指令，关闭所有Activity
    private void initRxBus() {
        mSubscription = RxBus.getInstance().toObservable(NormalEvent.class)
                .subscribe(new Action1<NormalEvent>() {
                               @Override
                               public void call(NormalEvent normalEvent) {
                                   if (normalEvent.getType() == -1) {
                                       finish();
                                   }
                               }
                           },
                        new Action1<Throwable>() {

                            @Override
                            public void call(Throwable throwable) {

                            }
                        });
    }

    /**
     * Todo
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
