package io.github.ypsitau.exampleroom2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		App.setLogEditText((EditText)findViewById(R.id.editText_log), false);
		AppDatabase db = App.getAppDatabase();
		User.DaoIf userDao = db.getUserDao();
		Pet.DaoIf petDao = db.getPetDao();
		UserWithPet.DaoIf userWithPetDao = db.getUserWithPetDao();
		if (userDao.countAll() == 0) {
			userDao.insert(new User(1, "User-A"));
			petDao.insert(new Pet("Pet1", 1));
			petDao.insert(new Pet("Pet2", 1));
			userDao.insert(new User(2, "User-B"));
			petDao.insert(new Pet("Pet3", 2));
			petDao.insert(new Pet("Pet4", 2));
			petDao.insert(new Pet("Pet5", 2));
			userDao.insert(new User(3, "User-C"));
			petDao.insert(new Pet("Pet6", 3));
		}
		App.printf("[User]\n");
		for (User user : userDao.selectAll()) {
			App.printf("%s\n", user.name);
		}
		App.printf("[Pet]\n");
		for (Pet pet : petDao.selectAll()) {
			App.printf("%s\n", pet.name);
		}
		App.printf("[UserWithPet]\n");
		for (UserWithPet userWithPet : userWithPetDao.selectAll()) {
			App.printf("%s\n", userWithPet.user.name);
			for (Pet pet : userWithPet.pets) {
				App.printf("  %s\n", pet.name);
			}
		}
	}
}
