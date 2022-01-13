package com.example.studyb

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.strictmode.SqliteObjectLeakedViolation
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.example.studyb.User
import java.lang.Exception


val DATABASE_NAME= "MyDB"
val TABLE_NAME= "Users"
val COL_NAME= "name"
val COL_NUMBER= "number"
val COL_EMAIL= "email"
val COL_PASSWORD= "pass"
val COL_COUNTRY= "country"
val COL_USERNAME= "username"


class DataBaseHandler (var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE "+TABLE_NAME+" ("+
                COL_NAME+" VARCHAR(256),"+
                COL_EMAIL+" VARCHAR(256),"+
                COL_PASSWORD+" VARCHAR(256),"+
                COL_USERNAME+" VARCHAR(256),"+
                COL_NUMBER+" INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

//    fun insertData(user: User){
//        val db= this.writableDatabase
//        var cv=  ContentValues()
//        cv.put(COL_NAME, user.name)
//        cv.put(COL_NUMBER, user.phoneNumber)
//        cv.put(COL_EMAIL, user.email)
//        cv.put(COL_PASSWORD, user.pass)
//        cv.put(COL_COUNTRY, user.country)
//        cv.put(COL_USERNAME, user.username)
////        if(result== -1.toLong())
////        else
//        db.insert(TABLE_NAME, null, cv)
//    }


}