package com.wobuddy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class VideoSpace extends Activity {
	
	public void test() {
		startActivity(new Intent(Intent.ACTION_VIEW,
			Uri.parse("http://www.youtube.com/watch?v=cxLG2wtE7TM")));
	}

}
