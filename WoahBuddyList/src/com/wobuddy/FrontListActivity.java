package com.wobuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.wobuddy.R;

public class FrontListActivity extends Activity {
	private ListView list;
	private FrontListAdapter adapter;
	private FrontListActivity activityContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.machineselect);

		this.list = (ListView) findViewById(R.id.machineList);
		this.adapter = new FrontListAdapter(this);
		this.list.setAdapter(adapter);

		this.list.setOnClickListener(listener);
		activityContext = this;
	}

	@Override
	public void onDestroy() {
		list.setAdapter(null);
		super.onDestroy();
	}

	public OnClickListener listener = new OnClickListener() {

		public void onClick(View view) {
			CharSequence text = "Hello toast!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(activityContext, text, duration);
			toast.show();
			adapter.notifyDataSetChanged();
		}
	};
}
