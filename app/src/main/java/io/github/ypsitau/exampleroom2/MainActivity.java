package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

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
		User.DaoIf userDao = db.getUserDao();
		Pet.DaoIf petDao = db.getPetDao();
		UserWithPet.DaoIf userWithPetDao = db.getUserWithPetDao();
		/*
		personDao.insert(new User(1, "User-A"));
		petDao.insert(new Pet("Pet1", 1));
		petDao.insert(new Pet("Pet2", 1));
		personDao.insert(new User(2, "User-B"));
		petDao.insert(new Pet("Pet3", 2));
		petDao.insert(new Pet("Pet4", 2));
		petDao.insert(new Pet("Pet5", 2));
		personDao.insert(new User(3, "User-C"));
		petDao.insert(new Pet("Pet6", 3));
		*/
		/*
		for (User user : userDao.selectAll()) {
			printf("%s\n", user.name);
		}
		for (Pet pet : petDao.selectAll()) {
			printf("%s\n", pet.name);
		}
		*/
		for (UserWithPet userWithPet : userWithPetDao.selectAll()) {
			printf("%s\n", userWithPet.user.name);
			for (Pet pet : userWithPet.pets) {
				printf("  %s\n", pet.name);
			}
		}
	}
	private void printf(String format, Object... args) {
		editText_log.append(String.format(format, args));
		editText_log.setSelection(editText_log.getText().length());
	}
}
