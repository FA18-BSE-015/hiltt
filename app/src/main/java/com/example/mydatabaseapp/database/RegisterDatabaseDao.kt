package com.example.mydatabaseapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import dagger.hilt.android.scopes.ViewModelScoped


@Dao
@ViewModelScoped
interface RegisterDatabaseDao {

    @Insert
    suspend fun insert(register: RegisterEntity)

    //@Delete
    //suspend  fun deleteSubscriber(register: RegisterEntity):Int

    @Query("SELECT * FROM Register_users_table ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<RegisterEntity>>

    @Query("DELETE FROM Register_users_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM Register_users_table WHERE user_name LIKE :userName")
    suspend fun getUsername(userName: String): RegisterEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(School:School)

    @Query("SELECT * FROM School")
    suspend fun getSchools():List<School>
}