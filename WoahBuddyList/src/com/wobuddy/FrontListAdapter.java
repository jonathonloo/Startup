package com.wobuddy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FrontListAdapter extends BaseAdapter {
	private Activity activity;
	private static LayoutInflater inflater = null;

	public FrontListAdapter(Activity a) {
		this.activity = a;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		String listLabel = "Error: Could not load";
		switch (position) {
		case 0:
			listLabel = "Hip Adductor";
			break;
		case 1:
			listLabel = "Treadmill";
			break;
		case 2:
			listLabel = "?";
			break;
		default:
			break;
		}
		RelativeLayout view = (RelativeLayout) inflater.inflate(
				R.layout.list_item, null, false);

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
