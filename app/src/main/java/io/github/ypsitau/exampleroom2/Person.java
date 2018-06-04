package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

import java.util.List;

@Entity
public class Person {
	@Dao
	public interface PersonDao {
		@Insert
		void insert(Person person);

		@Insert
		void insertMulti(Person... person);

		@Query("SELECT * FROM person")
		List<Person> selectAll();
	}
	@PrimaryKey(autoGenerate = true)
	public int uid;
	public String name;
	public Person(String name) {
		this.name = name;
	}
}
