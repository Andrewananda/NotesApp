package com.example.notes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notes.db.Word
import com.example.notes.db.WordRoomDatabase
import com.example.notes.repo.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(application: Application):AndroidViewModel(application) {

    private val repository : WordRepository

    val allWords : LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    //insert a new word
    fun insert(word:Word) = viewModelScope.launch {
        repository.insert(word)
    }

    fun clearAll()  = viewModelScope.launch {
        repository.clear()
    }

}