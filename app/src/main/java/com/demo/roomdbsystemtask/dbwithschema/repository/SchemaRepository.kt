package com.demo.roomdbsystemtask.dbwithschema.repository

import android.content.Context
import com.demo.roomdbsystemtask.dao.UserDao
import com.demo.roomdbsystemtask.database.AppDataBase
import com.demo.roomdbsystemtask.dbwithschema.dao.SchemaDAO
import com.demo.roomdbsystemtask.dbwithschema.database.SchemaDatabase
import com.demo.roomdbsystemtask.dbwithschema.model.User
import com.demo.roomdbsystemtask.model.UsersData

class SchemaRepository (context: Context) {
    var dao: SchemaDAO = SchemaDatabase.getInstance(context)?.getSchemauserDao()!!

    fun getAllUsers():List<User>{
        return dao.getAllUsers()!!
    }

    fun deletetUserBy(name:String){
        dao.deleteUserByName(name)
    }

    fun getUserByName(name:String):User{
        return dao.getUserByName(name)
    }

    fun insertUser(user:User){
        dao.insertUser(user)
    }
}