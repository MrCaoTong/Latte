package com.caotong.latte;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.latte.core.global.Latte;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(getApplicationContext())
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
