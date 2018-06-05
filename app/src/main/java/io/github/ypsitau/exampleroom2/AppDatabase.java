package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class, Pet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
	public abstract User.DaoIf getUserDao();
	public abstract Pet.DaoIf getPetDao();
	public abstract UserWithPet.DaoIf getUserWithPetDao();
}
