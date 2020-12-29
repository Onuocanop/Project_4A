package com.example.project_4a_kadioglu.data.repository

import com.example.project_4a_kadioglu.data.local.DatabaseDao
import com.example.project_4a_kadioglu.data.local.models.toData
import com.example.project_4a_kadioglu.data.local.models.toEntity
import com.example.project_4a_kadioglu.domain.entity.User

class UserRepository(private val databaseDao: DatabaseDao) {

    suspend fun createUser(user: User)
    {
        databaseDao.insert(user.toData())
    }


    fun getUser(email:String, password: String) : User?
    {
       val userLocal = databaseDao.findByName(email, password)
        return userLocal?.toEntity()
    }
}