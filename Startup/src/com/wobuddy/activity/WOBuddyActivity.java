package com.wobuddy.activity;

import com.wobuddy.R;
import com.wobuddy.R.layout;

import android.app.Activity;
import android.os.Bundle;

public class WOBuddyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}