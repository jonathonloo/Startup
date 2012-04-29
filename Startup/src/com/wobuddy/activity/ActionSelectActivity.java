package com.wobuddy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.wobuddy.R;

public class ActionSelectActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actionselect);
		
		Button scanButton = (Button) findViewById(R.id.scanButton);
		scanButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
			}
		});
		
		Button selectButton = (Button) findViewById(R.id.selectButton);
		selectButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
