package com.demo.roomdbsystemtask.dbwithschema.dao

import androidx.room.*
import com.demo.roomdbsystemtask.Constants
import com.demo.roomdbsystemtask.dbwithschema.model.User
import com.demo.roomdbsystemtask.model.UsersData

@Dao

interface SchemaDAO {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertUser(users: User)

        @Query("Select * from "+Constants.table_name_version_2)
        fun getAllUsers():List<User>

        @Update
        fun updateUser(user: User)

        @Delete
        fun deleteUser(user: User)

        @Query("Select * from "+Constants.table_name_version_2+" where firstname =:name")
        fun getUserByName(name:String): User

        @Query("DELETE FROM "+Constants.table_name_version_2+" where  firstname=:name")
        fun deleteUserByName(name:String)
}