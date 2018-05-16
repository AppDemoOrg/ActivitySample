package com.abt.activity.static_variable.leak;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

/**
 * @描述： @LeakedActivity
 * @作者： @黄卫旗
 * @创建时间： @2018/5/16
 */
public class LeakedActivity extends AppCompatActivity {

    private static InnerClass mInnerClass;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LeakedActivity.this.finish();
            this.removeMessages(0);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInnerClass = new InnerClass();
        mHandler.sendEmptyMessageDelayed(0,2000);
    }

    class InnerClass {
        public InnerClass () {
            Logger.d("InnerClass init!!!");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Logger.d("LeakedActivity has been recycled!!!");
    }

}
