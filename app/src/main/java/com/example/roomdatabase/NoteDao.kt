package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
@Dao
interface NoteDao {

    @Insert
    fun insertData(note: Note)

    @Update
    fun updateData(note: Note)

    @Delete
    fun delete(note: Note)
}