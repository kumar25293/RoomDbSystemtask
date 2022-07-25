package com.demo.roomdbsystemtask.repository

import android.content.Context
import com.demo.roomdbsystemtask.dao.UserDao
import com.demo.roomdbsystemtask.database.AppDataBase
import com.demo.roomdbsystemtask.model.UsersData

class UserRepository(context: Context) {

    var dao:UserDao = AppDataBase.getInstance(context)?.getuserDao()!!

    fun getAllUsers():List<UsersData>{
        return dao.getAllUsers()!!
    }

    fun insertUser(user:UsersData){
        dao.insertUser(user)
    }


    fun getUserByName(name:String):UsersData{
        return dao.getUserByName(name)
    }

    fun updateUser(user:UsersData){
        dao.updateUser(user)
    }

    fun deletetUser(user:UsersData){
        dao.deleteUser(user)
    }

    fun deletetUserByName(name:String){
        dao.deleteUserByName(name)
    }


}