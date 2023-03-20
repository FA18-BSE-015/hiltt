package com.example.mydatabaseapp.database

import android.util.Log
import androidx.lifecycle.LiveData
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RegisterRepository  @Inject constructor(private val dao: RegisterDatabaseDao) {

    val users = dao.getAllUsers()
    suspend fun insert(user: RegisterEntity) {
        return dao.insert(user)
    }

    suspend fun getUserName(userName: String):RegisterEntity?{
        Log.i("MYTAG", "inside Repository Getusers fun ")
        return dao.getUsername(userName)
    }
    //suspend fun deleteAll(): Int {
    //    return dao.deleteAll()
    //}

}