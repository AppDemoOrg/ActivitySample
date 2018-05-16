package com.abt.activity.static_variable;

import com.orhanobut.logger.Logger;

public class StaticModel {

    public static int num = 0;

    static {
        Logger.d("the static field of StaticModel has already be loaded: " + num);
    }

    public static class InnerClass {
        public static int staticNum = 0;
        static {
            Logger.d("the static field of InnerClass has already be loaded: " + num);
        }
    }
}
