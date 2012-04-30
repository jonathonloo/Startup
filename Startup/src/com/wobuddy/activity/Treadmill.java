package com.wobuddy.activity;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wobuddy.AppContext;
import com.wobuddy.R;
import com.wobuddy.RunEndDialogClick;

public class Treadmill extends Activity {
	public final static String URL = "url";
	private String url = "http://www.youtube.com/watch?feature=player_detailpage&v=Z_eC4gPHPRo#t=55s";
	private TextView dataView;
	private AppContext appContext;

	private Date startTime = null;
	private Date endTime = null;
	private Button startButton;
	private Button pauseButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timemachine);

		TextView title = (TextView) findViewById(R.id.viewTitle);
		Typeface titleFont = Typeface.createFromAsset(getAssets(),
				"fonts/leaguegothic.otf");
		Typeface bodyFont = Typeface.createFromAsset(getAssets(),
				"fonts/gotham-book.ttf");
		title.setText("Treadmill");
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

		Button submitButton = (Button) findViewById(R.id.Button);
		submitButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Builder ad = new AlertDialog.Builder(v.getContext());
				ad.setTitle("Run Complete!");
				long millis = (endTime.getTime() - startTime.getTime());
				String format = String.format(
						"%d:%d (m:s)",
						TimeUnit.MILLISECONDS.toMinutes(millis),
						TimeUnit.MILLISECONDS.toSeconds(millis)
								- TimeUnit.MINUTES
										.toSeconds(TimeUnit.MILLISECONDS
												.toMinutes(millis)));
				ad.setMessage("Time: " + format
						+ "\n\nHow far did you run?");
				LayoutInflater factory = LayoutInflater.from(v.getContext());
				final View textEntryView = factory.inflate(
						R.layout.distancelayout, null);
				ad.setView(textEntryView);
				ad.setPositiveButton("OK",
						new RunEndDialogClick(v.getContext()));
				ad.show();

				appContext.setLastUsedTreadmill(Calendar.getInstance()
						.getTime());
			}
		});

		// Start button
		startButton = (Button) findViewById(R.id.startTimer);
		startButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Calendar instance = Calendar.getInstance();
				startTime = instance.getTime();
			}
		});

		pauseButton = (Button) findViewById(R.id.pauseTimer);
		pauseButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Calendar instance = Calendar.getInstance();
				endTime = instance.getTime();
			}
		});

	}
}
