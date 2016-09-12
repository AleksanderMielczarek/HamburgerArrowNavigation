package com.github.aleksandermielczarek.hamburgerarrownavigationexample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Aleksander Mielczarek on 12.09.2016.
 */
public class HamburgerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
