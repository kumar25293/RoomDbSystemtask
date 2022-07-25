package com.demo.roomdbsystemtask.dbwithschema.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demo.roomdbsystemtask.Constants

@Entity(tableName = Constants.table_name_version_2)
data class User( @ColumnInfo(name ="firstname")
                 val username:String,
                 @ColumnInfo(name ="lastname")
                 val lastname:String,
@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "Id")
var userid:Int=0)
{

//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "Id")
//    var userid:Int?=null
}