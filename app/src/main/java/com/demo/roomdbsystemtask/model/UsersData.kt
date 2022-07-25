package com.demo.roomdbsystemtask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UsersData(
    @ColumnInfo(name ="first_name")
    val username:String,
    @ColumnInfo(name ="lase_name")
    val lastname:String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var userid:Int=0
    ){

    /** we should use primary key in this block and cannot use in constructor of data class.
     * IF we use it generate the crash while save new data as second **/

//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "Id")
//    var userid:Int?=null
}
