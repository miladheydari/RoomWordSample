package com.miladheydari.roomwordsample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.miladheydari.roomwordsample.utils.SingletonHolder
import com.miladheydari.roomwordsample.db.daos.WordDao
import com.miladheydari.roomwordsample.db.entities.Word


@Database(entities = [Word::class], version = 2)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao


    companion object : SingletonHolder<WordRoomDatabase, Context>({
        Room.databaseBuilder(it.applicationContext,
                WordRoomDatabase::class.java, "word_database")
                .build()
    })


}