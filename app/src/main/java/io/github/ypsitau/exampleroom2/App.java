package io.github.ypsitau.exampleroom2;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App extends Application {
	private AppDatabase db;

	private static App appInst;
	private static EditText editText_log;
	private static boolean timeStampFlag;

	@Override
	public void onCreate() {
		super.onCreate();
		appInst = this;
		db = Room.databaseBuilder(getApplicationContext(),
				AppDatabase.class, "exampleroom2.sqlite3").allowMainThreadQueries().build();
	}

	static App getInstance() { return appInst; }

	static Context getContext() { return getInstance().getApplicationContext(); }

	static AppDatabase getAppDatabase() { return getInstance().db; }

	static void setLogEditText(EditText editText_log, boolean timeStampFlag) {
		App.editText_log = editText_log;
		App.timeStampFlag = timeStampFlag;
		editText_log.setBackgroundColor(Color.WHITE);
		editText_log.setFocusable(false);
		editText_log.setTextIsSelectable(true);
		editText_log.setGravity(Gravity.TOP);
		editText_log.setTextSize(14); // set font size 14sp
		editText_log.setTypeface(Typeface.MONOSPACE);
	}

	static void printf(String format, Object... args) {
		final DateFormat df = new SimpleDateFormat("HH:mm:ss.SS ");
		final Date date = new Date(System.currentTimeMillis());
		String msg = "";
		if (timeStampFlag) msg = df.format(date);
		msg += String.format(format, args);
		Log.i(appInst.getString(R.string.app_name), msg);
		EditText editText_log = getInstance().editText_log;
		if (editText_log != null) {
			editText_log.append(msg);
			editText_log.setSelection(editText_log.getText().length());
		}
	}
}
