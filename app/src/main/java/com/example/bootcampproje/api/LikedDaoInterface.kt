package com.example.bootcampproje.api

import com.example.bootcampproje.model.AddLikedItemRequest
import com.example.bootcampproje.model.AddLikedItemResponse
import com.example.bootcampproje.model.GetLikedItemsRequest
import com.example.bootcampproje.model.GetLikedItemsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface LikedDaoInterface {
    @Headers("Content-Type: application/json")
    @POST("api/users/likeditems")
    suspend fun getLikedItems(@Body like: GetLikedItemsRequest): Response<GetLikedItemsResponse>

    @Headers("Content-Type: application/json")
    @POST("api/users/like")
    suspend fun addLikedItems(@Body like: AddLikedItemRequest): Response<AddLikedItemResponse>


}