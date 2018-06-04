package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

import java.util.List;

@Entity
public class User {
	@Dao
	public interface UserDao {
		@Query("SELECT * FROM user")
		List<User> selectAll();

		@Query("SELECT * FROM user WHERE uid IN (:uids)")
		List<User> selectByIds(int[] uids);

		@Query("SELECT * FROM user WHERE firstName LIKE :firstName AND "
				+ "lastName LIKE :lastName LIMIT 1")
		User selectByName(String firstName, String lastName);

		@Query("SELECT COUNT(*) FROM user")
		int countAll();

		@Insert
		void insert(User user);

		@Insert
		void insertMulti(User... users);

		@Delete
		void delete(User user);

		@Query("DELETE FROM user")
		void deleteAll();
	}

	@PrimaryKey(autoGenerate = true)
	public int uid;
	public String firstName;
	public String lastName;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
