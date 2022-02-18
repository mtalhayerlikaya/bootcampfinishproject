package com.example.bootcampproje.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bootcampproje.model.BegenilenUrunler

@Database(entities = [BegenilenUrunler::class], version = 1)
abstract class RoomDB: RoomDatabase() {
    abstract fun foodsDao() : BegenilenUrunDAO

    companion object{
        var INSTANCE : RoomDB? = null

        fun getDatabase(context: Context) : RoomDB? {
            if (INSTANCE == null){
                synchronized(RoomDB::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,RoomDB::class.java,
                        "likefood.sqlite").createFromAsset("likefood.sqlite").build()
                }
            }
            return INSTANCE
        }
    }

}