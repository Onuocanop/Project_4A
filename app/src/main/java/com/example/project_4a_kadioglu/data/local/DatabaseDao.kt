package com.example.project_4a_kadioglu.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.project_4a_kadioglu.data.local.models.UserLocal

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM UserLocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM UserLocal WHERE (email LIKE :email AND password LIKE :password) LIMIT 1")
    fun findByName(email: String, password: String): UserLocal

    @Insert
    fun insert( user: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}