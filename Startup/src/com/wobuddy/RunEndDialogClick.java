package com.wobuddy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

public class RunEndDialogClick implements OnClickListener {

	private Context context;

	public RunEndDialogClick(Context context) {
		this.context = context;
	}

	public void onClick(DialogInterface dialog, int which) {
		Toast toast = Toast.makeText(this.context, "Your run has been saved",
				Toast.LENGTH_LONG);
		toast.show();
		dialog.cancel();
	}

}
