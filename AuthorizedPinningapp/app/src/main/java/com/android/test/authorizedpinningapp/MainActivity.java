package com.android.test.authorizedpinningapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends Activity {

    private Button pinAppBtn;
    private Button unpinAppBtn;
    private ActivityManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinAppBtn = (Button) findViewById(R.id.pin_app);
        unpinAppBtn = (Button) findViewById(R.id.unpin_app);

        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        pinAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pin();
            }
        });
        unpinAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unpin();
            }
        });

    }

    private void unpin() {
        if(am.isInLockTaskMode()) {
            stopLockTask();
        } else {
            Toast.makeText(this, "Application already unpinned !", LENGTH_LONG).show();
        }
    }

    private void pin() {
        // if(!am.isInLockTaskMode()) {
            startLockTask();
        //} else {
        //    Toast.makeText(this, "Application already pinned !", LENGTH_LONG).show();
        //}
    }



}
