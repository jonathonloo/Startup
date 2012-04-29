package com.wobuddy;

import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FrontList extends ListActivity {
	public final static String[] ITEMS = {
		"Tutorial",
		"Notes",
		"Broadcast"
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  

	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, ITEMS));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    	// first is tutorial
	    	if (position == 0) {
	    		showVideo();
	    	}
	    	// second is notes
	    	// third is broadcast
	    	Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT);
	    }
	  });

	}
	
	public void showVideo() {
		Intent i = new Intent(Intent.ACTION_VIEW,
				  Uri.parse("http://www.youtube.com/watch?v=O74gVrtcSrY"));
		startActivity(i);
	}
	
}
