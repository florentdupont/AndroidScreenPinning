package com.android.test.deviceownerapp;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * A minimalist Device Owner App used to validate Screen pinning's behavior.
 */
public class MainActivity extends Activity {

    private Button setAuthorizedAppsBtn;
    private Button clearAuthorizedAppsBtn;
    private CheckBox isMyAppAuthorizedChk;

    private DevicePolicyManager mDPM;
    private ComponentName mDeviceAdminRcvr;

    private static final String MY_AUTHORIZED_APP = "com.android.test.authorizedpinningapp";
    private static final String[] AUTHORIZED_PINNING_APPS = {MY_AUTHORIZED_APP};
    private static final String[] NO_AUTHORIZED_PINNING_APP = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAuthorizedAppsBtn = (Button) findViewById(R.id.set_authorized_apps_btn);
        clearAuthorizedAppsBtn = (Button) findViewById(R.id.clear_authorized_apps_btn);
        isMyAppAuthorizedChk = (CheckBox) findViewById(R.id.is_app_pinnable);

        mDPM = (DevicePolicyManager) this.getSystemService(DEVICE_POLICY_SERVICE);
        mDeviceAdminRcvr = new ComponentName(this, MyDeviceAdminReceiver.class);

        setAuthorizedAppsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAuthorizedApps();
            }
        });
        clearAuthorizedAppsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAuthorizedApps();
            }
        });
        updateAppPinnableChk();
    }

    private void setAuthorizedApps() {
        mDPM.setLockTaskPackages(mDeviceAdminRcvr, AUTHORIZED_PINNING_APPS);
        updateAppPinnableChk();
    }

    private void clearAuthorizedApps() {
        mDPM.setLockTaskPackages(mDeviceAdminRcvr, NO_AUTHORIZED_PINNING_APP );
        updateAppPinnableChk();
    }

    private void updateAppPinnableChk() {
        boolean authorized = mDPM.isLockTaskPermitted(MY_AUTHORIZED_APP);
        isMyAppAuthorizedChk.setChecked(authorized);
    }
}
