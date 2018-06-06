package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

import java.util.List;

@Entity(indices = {@Index("uid")})
public class User {
	@Dao
	public interface DaoIf {
		@Insert
		void insert(User user);

		@Insert
		void insertMulti(User... users);

		@Query("SELECT * FROM User")
		List<User> selectAll();

		@Query("SELECT COUNT(*) FROM User")
		int countAll();
	}
	@PrimaryKey
	public int uid;
	public String name;
	public User(int uid, String name) {
		this.uid = uid;
		this.name = name;
	}
}
