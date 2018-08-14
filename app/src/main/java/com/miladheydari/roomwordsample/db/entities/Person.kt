package com.miladheydari.roomwordsample.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey


open class Person(@field:[
             ColumnInfo(name = "id")
             PrimaryKey] var id: String)


