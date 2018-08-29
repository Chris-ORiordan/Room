package com.example.standard.room;

import android.arch.persistence.room.*;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT(*) FROM user")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
