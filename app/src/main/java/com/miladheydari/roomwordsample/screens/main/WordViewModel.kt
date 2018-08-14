package com.miladheydari.roomwordsample.screens.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.miladheydari.roomwordsample.db.entities.Word
import com.miladheydari.roomwordsample.repositories.WordRepository
import io.reactivex.Flowable

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private var mRepository: WordRepository = WordRepository(application)


    var mAllWords: Flowable<List<Word>>

    init {
        mAllWords = mRepository.allWords
    }

    fun insert(word: Word) {
        mRepository.insert(word)
    }
}