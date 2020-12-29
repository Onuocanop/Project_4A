package com.example.project_4a_kadioglu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project_4a_kadioglu.data.local.models.UserLocal

@Database(entities = [UserLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}