package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UserWithPet {
	@Dao
	public interface DaoIf {
		@Query("SELECT * from User")
		public List<UserWithPet> selectAll();
	}
	@Embedded
	public User user;
	@Relation(parentColumn = "uid", entityColumn = "uidUser")
	public List<Pet> pets;
}
