package com.wobuddy.activity;

import java.util.Calendar;

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

import com.wobuddy.AppContext;
import com.wobuddy.R;

public class IsoLip extends Activity {
	public final static String URL = "url";
	private String url = "http://www.youtube.com/watch?v=al_vDXyuhak";
	private Spinner weightSpinner;
	private Spinner repSpinner;
	private TextView dataView;
	private AppContext appContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.repmachine);

		TextView title = (TextView) findViewById(R.id.viewTitle);
		Typeface titleFont = Typeface.createFromAsset(getAssets(),
				"fonts/leaguegothic.otf");
		Typeface bodyFont = Typeface.createFromAsset(getAssets(),
				"fonts/gothambook.ttf");
		title.setText("Iso-Lateral Incline Press");
		title.setTypeface(titleFont);
		
		TextView bodyTitle = (TextView) findViewById(R.id.textView2);
		bodyTitle.setTypeface(titleFont);
		
		TextView tutorialTitle = (TextView) findViewById(R.id.tutorialText);
		tutorialTitle.setTypeface(bodyFont);
		
		// Set spinners
		weightSpinner = (Spinner) findViewById(R.id.weightSpinner);
		repSpinner = (Spinner) findViewById(R.id.repSpinner);
		dataView = (TextView) findViewById(R.id.historicalText);
		appContext = (AppContext) getApplicationContext();

		// Tutorial button
		ImageButton tutorial = (ImageButton) findViewById(R.id.videoTutorial);

		tutorial.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(i);
			}
		});

		// Add button
		ImageButton addButton = (ImageButton) findViewById(R.id.addRowButton);
		addButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				appContext.appendIslipData(repSpinner.getSelectedItem()
						.toString()
						+ " reps at "
						+ weightSpinner.getSelectedItem().toString()
						+ " pounds");
				dataView.setText(appContext.getIslipData());
			}
		});

		ImageButton submitButton = (ImageButton) findViewById(R.id.submitButton);
		submitButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				int reps = Integer.parseInt(repSpinner.getSelectedItem()
						.toString());
				int weight = Integer.parseInt(weightSpinner.getSelectedItem()
						.toString());

				Builder ad = new AlertDialog.Builder(v.getContext());
				ad.setTitle("Machine Complete!");
				ad.setMessage("Your data has been saved");
				ad.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								appContext.clearIslipData();
								dataView.setText(appContext.getIslipData());
								dialog.cancel();
							}
						});
				ad.show();

				appContext.setLastUsedIslip(Calendar.getInstance().getTime());

			}
		});
		dataView.setText(appContext.getIslipData());

	}
}
