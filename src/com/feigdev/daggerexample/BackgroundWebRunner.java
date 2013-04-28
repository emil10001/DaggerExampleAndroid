package com.feigdev.daggerexample;


import android.os.AsyncTask;
import android.util.Log;

import com.github.kevinsawicki.http.HttpRequest;

public class BackgroundWebRunner extends AsyncTask<Void, Void, String> {
	private static final String TAG = "BackgroundWebRunner";
	private static final String ENDPOINT = "http://dev.feigdev.com:58912/get_response";

	@Override
	protected String doInBackground(Void... arg0) {
		return HttpRequest.get(ENDPOINT).body();
	}

	@Override
	protected void onPostExecute(String result) {
		Log.d(TAG, "Response was: " + result);
		BusProvider.getInstance().register(this);
		BusProvider.getInstance().post(result);
		BusProvider.getInstance().unregister(this);
	}
}
