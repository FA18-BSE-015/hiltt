package com.example.mydatabaseapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)

@Database(entities = [RegisterEntity::class, School::class], version = 2,
   // autoMigrations=[
     //   AutoMigration(from =1, to= 2, spec= RegisterDatabase.Migration1To2::class)
    //])
  exportSchema = false)
abstract class RegisterDatabase : RoomDatabase() {

    abstract val registerDatabaseDao: RegisterDatabaseDao


    companion object {

        val migration1To2 = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS school(name CHAR NOT NULL PRIMARY KEY) ")

            }

        }

        @Volatile
        private var INSTANCE: RegisterDatabase? = null
        @Singleton
        @Provides
        fun getInstance(context: Context): RegisterDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RegisterDatabase::class.java,
                        "user_details_database"
                    ).addMigrations(migration1To2).build()
                       //.fallbackToDestructiveMigration()
                    INSTANCE = instance
                }
                return instance
            }
        }

}}

