package com.deange.githubstatus;

import android.app.Application;
import android.util.Log;

import com.deange.githubstatus.controller.GsonController;
import com.deange.githubstatus.controller.NotificationController;
import com.deange.githubstatus.controller.StateController;

public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate()");
        super.onCreate();

        try {
            // Initialize the Gson singleton
            GsonController.getInstance();

            // Initialize the SharedPreferences wrapper
            StateController.createInstance(getApplicationContext());

            // Initialize the Notification service
            NotificationController.createInstance(getApplicationContext());

        } catch (final Exception e) {
            Log.wtf(TAG, "Fatal error occured!", e);
        }
    }

}
