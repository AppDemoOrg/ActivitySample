package com.abt.activity.static_variable.leak;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.abt.activity.R;
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
        setContentView(R.layout.activity_leak);
        final TextView tipsView = findViewById(R.id.textView);
        tipsView.setText(LeakedActivity.class.getSimpleName());

        mInnerClass = new InnerClass();
        //mHandler.sendEmptyMessageDelayed(0,2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("onDestroy()");
    }

    static class InnerClass {
        public InnerClass () {
            Logger.d("InnerClass init!!!");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Logger.d("LeakedActivity has been recycled!!!");
        /** 退出Activity，然后通过IDE强制触发一次GC操作 */
        /** 有打印，则无内存泄漏，无打印则肯定有内存泄漏了！ */
    }

    public static final void startActivity(Context context) {
        final Intent intent = new Intent(context, LeakedActivity.class);
        context.startActivity(intent);
    }

}
