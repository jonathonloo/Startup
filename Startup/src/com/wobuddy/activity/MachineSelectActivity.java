package com.wobuddy.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.wobuddy.MachineSelectAdapter;
import com.wobuddy.R;

public class MachineSelectActivity extends Activity {
	private ListView list;
	private MachineSelectAdapter adapter;
	private MachineSelectActivity activityContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.machinelist);
	}

	@Override
	protected void onStart() {
		super.onStart();

		this.list = (ListView) findViewById(R.id.machineListView);
		this.adapter = new MachineSelectAdapter(this);
		this.list.setAdapter(adapter);

		this.list.setOnItemClickListener(listener);
		activityContext = this;

	}

	@Override
	public void onDestroy() {
		list.setAdapter(null);
		super.onDestroy();
	}

	public OnItemClickListener listener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent i = null;
			switch (position) {
			case 0:
				i = new Intent(view.getContext(), Hip.class);
				startActivity(i);
				break;
			case 1:
				i = new Intent(view.getContext(), Treadmill.class);
				startActivity(i);
				break;
			case 2:
				i = new Intent(view.getContext(), IsoLip.class);
				startActivity(i);
				break;
			default:
				break;
			}
		}
	};
}
