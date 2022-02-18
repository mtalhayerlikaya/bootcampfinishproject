package com.example.bootcampproje.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "begenilen_urunler")
data class BegenilenUrunler(
    @PrimaryKey
    @ColumnInfo(name = "kul_adi")
    val kul_adi: String,
    @ColumnInfo(name = "urun_ismi")
    val urun_ismi: String

)