package com.miladheydari.roomwordsample.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "word")

class Word(id: String) : Person(id) {


    @ColumnInfo(name = "name")
    var name: String = ""


    var person: Person? = null

}
