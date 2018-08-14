package com.miladheydari.roomwordsample.db.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.miladheydari.roomwordsample.db.entities.Word
import io.reactivex.Flowable

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Query("select * from   word  order by name asc")
    fun getAll(): Flowable<List<Word>>


    @Query("delete from word")
    fun deleteAll()
}