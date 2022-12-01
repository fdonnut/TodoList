package com.donnut.todolist;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    List<Note> getNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNote(Note note);

    @Query("DELETE FROM notes WHERE id = :id")
    void remove(int id);
}
