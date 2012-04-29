package com.wobuddy.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.wobuddy.R;

public class ActionSelectActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actionselect);

		Button scanButton = (Button) findViewById(R.id.scanButton);
		scanButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(
						"com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
			}
		});

		ImageButton selectButton = (ImageButton) findViewById(R.id.selectButton);
		selectButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent("com.wobuddy.activity.MACHINELIST");
				startActivityForResult(intent, 0);
			}
		});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
			}
		}
	}
}
