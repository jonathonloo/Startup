package com.wobuddy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MachineSelectAdapter extends BaseAdapter {
	private Activity activity;
	private static LayoutInflater inflater = null;

	public MachineSelectAdapter(Activity a) {
		this.activity = a;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		int imageId = 0;
		String listLabel = "Error: Could not load";
		switch (position) {
		case 0:
			imageId = R.drawable.browse_hipadduction;
			listLabel = "Hip Adductor";
			break;
		case 1:
			imageId = R.drawable.browse_treadmill;
			listLabel = "Treadmill";
			break;
		case 2:
			imageId = R.drawable.browse_ilip;
			listLabel = "Iso-lateral Incline Press";
			break;
		default:
			break;
		}
		RelativeLayout view = (RelativeLayout) inflater.inflate(
				R.layout.machineselect, null, false);

		ImageView image = (ImageView) view.findViewById(R.id.machineIcon);
		image.setImageResource(imageId);

		TextView name = (TextView) view.findViewById(R.id.machineName);
		name.setText(listLabel);

		return view;
	}

	public int getCount() {
		return 3;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}
}
