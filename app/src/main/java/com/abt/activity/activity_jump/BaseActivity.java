package com.abt.activity.activity_jump;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * @描述： @BaseActivity
 * @作者： @黄卫旗
 * @创建时间： @30/05/2018
 */
public class BaseActivity extends AppCompatActivity {

    protected void getTask() {
        // 获取activity任务栈
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = manager.getRunningTasks(1);
        Logger.d("list.size()="+list.size());
        for (ActivityManager.RunningTaskInfo info : list) {
            // 类名 .activity_jump.ActivityA
            String shortClassName = info.topActivity.getShortClassName();
            Logger.d("shortClassName = "+shortClassName);
            // 完整类名 com.abt.activity.activity_jump.ActivityA
            String className = info.topActivity.getClassName();
            // 包名 com.abt.activity
            String packageName = info.topActivity.getPackageName();
        }
    }

}
