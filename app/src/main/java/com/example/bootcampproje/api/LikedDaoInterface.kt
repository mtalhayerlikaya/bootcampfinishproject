package com.example.bootcampproje.api

import com.example.bootcampproje.model.*
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

    @Headers("Content-Type: application/json")
    @POST("api/users/signup")
    suspend fun signUpRequest(@Body request: SignUpRequest):Response<SignUpResponse>

    @Headers("Content-Type: application/json")
    @POST("api/users/login")
    suspend fun loginRequest(@Body request: LoginRequest):Response<LoginResponse>


}