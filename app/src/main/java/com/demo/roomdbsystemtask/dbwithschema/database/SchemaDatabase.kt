package com.demo.roomdbsystemtask.dbwithschema.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.demo.roomdbsystemtask.dao.UserDao
import com.demo.roomdbsystemtask.database.AppDataBase
import com.demo.roomdbsystemtask.dbwithschema.dao.SchemaDAO
import com.demo.roomdbsystemtask.dbwithschema.model.User
import com.demo.roomdbsystemtask.model.UsersData

@Database(entities = [User::class],version = 2,exportSchema = true)

abstract class SchemaDatabase:RoomDatabase() {

    abstract fun getSchemauserDao(): SchemaDAO

    companion object{
        private var dBInstance: SchemaDatabase?=null

        fun getInstance(context: Context): SchemaDatabase?{
            dBInstance = Room.databaseBuilder(context, SchemaDatabase::class.java,"user_table.db")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build()
            return dBInstance
        }

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.run {
                    execSQL("ALTER TABLE user_table RENAME TO user_new")
                }
            }
        }
    }
}