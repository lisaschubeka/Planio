package com.example.storage.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.File

@Entity
data class PlantIndividual (

    @PrimaryKey(autoGenerate = true)
    val plantId: Long = 0L,

    @ColumnInfo
    var plantName: String = "",

    @ColumnInfo
    var plantFilePath: File,
)

