package io.github.ypsitau.exampleroom2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

import java.util.List;

@Entity(indices = {@Index("uidUser")},
		foreignKeys = @ForeignKey(entity = User.class, parentColumns= "uid", childColumns = "uidUser"))
public class Pet {
	@Dao
	public interface DaoIf {
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
	public int uidUser;
	public Pet(String name, int uidUser) {
		this.name = name;
		this.uidUser = uidUser;
	}
}
