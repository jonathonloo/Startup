package com.wobuddy.activity;

import java.util.Calendar;

import com.wobuddy.AppContext;
import com.wobuddy.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Treadmill extends Activity {
	public final static String URL = "url";
	private String url = "http://www.youtube.com/watch?feature=player_detailpage&v=Z_eC4gPHPRo#t=55s";
	private TextView dataView;
	private AppContext appContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timemachine);
		
		TextView title = (TextView) findViewById(R.id.viewTitle);
		Typeface titleFont = Typeface.createFromAsset(getAssets(),
				"fonts/leaguegothic.otf");
		Typeface bodyFont = Typeface.createFromAsset(getAssets(),
				"fonts/gotham-book.ttf");
		title.setText("Hip Adductor");
		title.setTypeface(titleFont);

		dataView = (TextView) findViewById(R.id.historicalText);
		appContext = (AppContext) getApplicationContext();

		// Tutorial button
		Button tutorial = (Button) findViewById(R.id.videoTutorial);

		tutorial.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(i);
			}
		});

		Button submitButton = (Button) findViewById(R.id.submitButton);
		submitButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Builder ad = new AlertDialog.Builder(v.getContext());
				ad.setTitle("Machine Complete!");
				ad.setMessage("Your data has been saved");
				ad.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								appContext.clearHipData();
								dataView.setText(appContext.getHipData());
								dialog.cancel();
							}
						});
				ad.show();

				appContext.setLastUsedHip(Calendar.getInstance().getTime());
			}
		});

	}
}
