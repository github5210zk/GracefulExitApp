package com.zk.gracefulexitapp.one;

/**
 * Created by ${zk} on 2018/4/6 0006.
 * 欢迎每一天
 */

public class NormalEvent {
    private int type;//标记

    public NormalEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
