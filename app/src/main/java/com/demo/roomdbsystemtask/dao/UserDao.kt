package com.demo.roomdbsystemtask.dao

import androidx.room.*
import com.demo.roomdbsystemtask.model.UsersData

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users:UsersData)

    @Query("Select * from user")
    fun getAllUsers():List<UsersData>

    @Update
    fun updateUser(user:UsersData)

    @Delete
    fun deleteUser(user:UsersData)

    @Query("Select * from user where first_name =:name")
    fun getUserByName(name:String):UsersData

    @Query("DELETE FROM user where  first_name=:name")
    fun deleteUserByName(name:String)



}