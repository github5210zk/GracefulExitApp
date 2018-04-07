package com.zk.gracefulexitapp.one;


import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by ${zk} on 2018/4/6 0006.
 * 欢迎每一天
 */

public class RxBus {
    private static volatile RxBus   mInstance;
    private final           Subject bus;

    public RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 单列模式RxBus
     */
    public static RxBus getInstance() {
        RxBus rxBus = mInstance;
        if (mInstance == null) {
            synchronized (RxBus.class) {
                rxBus = mInstance;
                if (mInstance == null) {
                    rxBus = new RxBus();
                    mInstance = rxBus;
                }
            }
        }
        return mInstance;
    }

    /**
     * 发送消息
     *
     * @param object
     */
    public void post(Object object) {
        bus.onNext(object);
    }

    /**
     * 接收消息
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

}
