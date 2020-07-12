package com.TruDoc.Weather.data.db.dao;

import com.TruDoc.Weather.data.db.model.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert(onConflict = REPLACE)
    void insertUser(User mUser);

    @Insert
    void insertAllUser(User... mUsersList);

    @Delete
    void deleteUser(User mUser);

    @Update
    void updateUser(User mUser);

    @Query("SELECT * FROM user WHERE uid = :uId")
    User getUserById(int uId);


    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);
}

