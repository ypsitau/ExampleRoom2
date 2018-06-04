package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

import java.util.List;

@Entity(foreignKeys = @ForeignKey(entity = Person.class, parentColumns= "uid", childColumns = "uidPerson"))
public class Pet {
	@Dao
	public interface PetDao {
		@Insert
		void insert(Pet pet);

		@Insert
		void insertMulti(Pet... pet);

		@Query("SELECT * FROM pet")
		List<Pet> selectAll();
	}

	@PrimaryKey(autoGenerate = true)
	public int uid;
	public String name;
	public int uidPerson;
	public Pet(String name, int uidPerson) {
		this.name = name;
		this.uidPerson = uidPerson;
	}
}
