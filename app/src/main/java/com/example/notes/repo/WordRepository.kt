package com.example.notes.repo

import androidx.lifecycle.LiveData
import com.example.notes.db.Word
import com.example.notes.db.WordDao

class WordRepository(private val wordDao:WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }

}