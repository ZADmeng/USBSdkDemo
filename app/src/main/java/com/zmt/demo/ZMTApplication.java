package com.zmt.demo;

import android.app.Application;
import android.content.Intent;

import com.hoho.android.usbserial.service.PushDataServer;

/**
 * 作者：王东一
 * 创建时间：2018/11/1.
 */
public class ZMTApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(getApplicationContext(), PushDataServer.class);
        startService(intent);
    }
}
