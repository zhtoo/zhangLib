package com.hs.recyclerviewdemo.app;

import android.app.Application;
import android.content.Context;

public class AppApplication extends Application{
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
