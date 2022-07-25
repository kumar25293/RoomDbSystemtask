package com.demo.roomdbsystemtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.roomdbsystemtask.dao.UserDao
import com.demo.roomdbsystemtask.model.UsersData


@Database(entities = [UsersData::class],version = 2,exportSchema = false)
abstract  class AppDataBase:RoomDatabase() {

    abstract fun getuserDao():UserDao

    companion object{
        private var dBInstance:AppDataBase?=null

        fun getInstance(context:Context):AppDataBase?{
            dBInstance = Room.databaseBuilder(context,AppDataBase::class.java,"user.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            return dBInstance
        }
    }
}