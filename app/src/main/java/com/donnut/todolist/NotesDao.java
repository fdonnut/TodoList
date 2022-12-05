package com.donnut.todolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable addNote(Note note);

    @Query("DELETE FROM notes WHERE id = :id")
    void remove(int id);
}
