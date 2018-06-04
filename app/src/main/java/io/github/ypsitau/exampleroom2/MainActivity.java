package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";
	AppDatabase db;
	EditText editText_log;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText_log = findViewById(R.id.editText_log);
		db = Room.databaseBuilder(getApplicationContext(),
				AppDatabase.class, "exampleroom2.sqlite3").allowMainThreadQueries().build();
		db.getPersonDao().insert(new Person("Person-A"));
		db.getPersonDao().insert(new Person("Person-B"));
		db.getPersonDao().insert(new Person("Person-C"));
		db.getPersonDao().insert(new Person("Person-D"));
		db.getPersonDao().insert(new Person("Person-E"));
		db.getPersonDao().insert(new Person("Person-F"));


		db.getUserDao().insertMulti(
				new User("first1", "last1"),
				new User("first2", "last2"),
				new User("first3", "last3"),
				new User("first4", "last4"),
				new User("first5", "last5"),
				new User("first6", "last6"),
				new User("first7", "last7"),
				new User("first8", "last8"));
		List<User> users = db.getUserDao().selectAll();
		for (User user : users) {
			printf("%s\n", user.firstName);
		}
	}
	private void printf(String format, Object... args) {
		editText_log.append(String.format(format, args));
		editText_log.setSelection(editText_log.getText().length());
	}
}
