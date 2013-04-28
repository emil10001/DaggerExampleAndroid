package com.feigdev.daggerexample;

import android.os.AsyncTask;
import android.util.Log;

public class AlternateJsonProvider extends AsyncTask<Void, Void, String> {
	private static final String TAG = "BackgroundWebRunner";
	private static final String JSON_STRING = "{'hostname':'local provider',"
			+ "'user':'user',"
			+ "'auth_token':'ajfowienfoani/nawogfina/1w3inoangoins',"
			+ "'password':'password','database':'database'}";

	@Override
	protected String doInBackground(Void... arg0) {
		return JSON_STRING;
	}

	@Override
	protected void onPostExecute(String result) {
		Log.d(TAG, "Response was: " + result);
		BusProvider.getInstance().register(this);
		BusProvider.getInstance().post(result);
		BusProvider.getInstance().unregister(this);
	}
}
