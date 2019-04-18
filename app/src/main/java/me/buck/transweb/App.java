package me.buck.transweb;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by gwf on 2019/4/14
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        Timber.d("启动 APP");
    }
}
