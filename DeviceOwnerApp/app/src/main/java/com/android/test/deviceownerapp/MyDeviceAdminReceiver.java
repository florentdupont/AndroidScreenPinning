package com.android.test.deviceownerapp;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;


public class MyDeviceAdminReceiver extends DeviceAdminReceiver {

    private static final String TAG = "DeviceOwnerApp";

    @Override
    public void onLockTaskModeEntering(Context context, Intent intent, String pkg) {
        Toast.makeText(context, "Lock task mode entered", LENGTH_LONG).show();
        Log.i(TAG, "Lock task mode entered");
        Log.i(TAG, "action  : " + intent.getAction());
        Log.i(TAG, "package : " + intent.getStringExtra(DeviceAdminReceiver.EXTRA_LOCK_TASK_PACKAGE));
    }

    @Override
    public void onLockTaskModeExiting(Context context, Intent intent) {
        Toast.makeText(context, "Lock task mode exited", LENGTH_LONG).show();
        Log.i(TAG, "Lock task mode exited");
        Log.i(TAG, "action  : " + intent.getAction());
        Log.i(TAG, "package : " + intent.getStringExtra(DeviceAdminReceiver.EXTRA_LOCK_TASK_PACKAGE));
    }
}
