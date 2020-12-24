package com.example.project_4a_kadioglu.injection

import android.content.Context
import androidx.room.Room
import com.example.project_4a_kadioglu.data.local.AppDatabase
import com.example.project_4a_kadioglu.data.repository.UserRepository
import com.example.project_4a_kadioglu.domain.usecase.CreateUserUseCase
import com.example.project_4a_kadioglu.presentation.main.MainViewModule
import com.example.project_4a_kadioglu.data.local.DatabaseDao
import com.example.project_4a_kadioglu.domain.usecase.GetUserUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val  presentationModule = module {
    factory{ MainViewModule(get(), get()) }
}

val domainModule = module{
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module{
    single{ UserRepository(get()) }
    single{ createDatabase(androidContext()) }
}


fun createDatabase(context: Context): DatabaseDao
{
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}


