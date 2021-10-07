package com.abhishek.to_do.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abhishek.to_do.data.models.ToDoData

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao() : ToDoDao

    /**
     * Companion Object cause database needs to be created only once
     */
    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        /**
         * Get the instance of the database and built one if not present
         *
         * @param context
         * @return Databse object
         */
        fun getDatabase(context: Context): ToDoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        /**
         * Method to build a database
         *
         * @param context
         * @return
         */
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ToDoDatabase::class.java, "todo_database"
            ).build()
    }
}
