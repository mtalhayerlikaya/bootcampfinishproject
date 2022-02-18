package com.example.bootcampproje.RoomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bootcampproje.model.BegenilenUrunler

@Dao
interface BegenilenUrunDAO {

    @Query("SELECT urun_ismi FROM begenilen_urunler")
    suspend fun getLikedFood(): List<String>

    @Insert
    suspend fun addLikedFood(urun:BegenilenUrunler)


}