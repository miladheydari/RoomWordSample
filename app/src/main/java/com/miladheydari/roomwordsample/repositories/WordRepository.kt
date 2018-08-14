package com.miladheydari.roomwordsample.repositories

import android.app.Application
import android.os.AsyncTask
import com.miladheydari.roomwordsample.db.WordRoomDatabase
import com.miladheydari.roomwordsample.db.daos.WordDao
import com.miladheydari.roomwordsample.db.entities.Word


import io.reactivex.Flowable

class WordRepository(application: Application) {

      private val wordDao: WordDao
      val allWords: Flowable<List<Word>>


    init {
        val db = WordRoomDatabase.getInstance(application)
        wordDao = db.wordDao()
        allWords = wordDao.getAll()
    }

    fun insert(word: Word) {
        InsertAsyncTask(wordDao).execute(word)
    }

    private class InsertAsyncTask(private val mAsyncTaskDao: WordDao) : AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}