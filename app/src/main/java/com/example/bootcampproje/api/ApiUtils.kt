package com.example.bootcampproje.api

class ApiUtils {

    companion object{
        val BASE_URL = "http://bootcampserver1.herokuapp.com/"
       // val LOGIN_BASE_URL = "https://bootcampserver1.herokuapp.com/"
        //const val LIKED_URL="https://bootcampserver1.herokuapp.com/api/users/likeditems"
        fun getKisilerDaoInterface() : LikedDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(LikedDaoInterface::class.java)
        }

        fun getInterfaceLoginAndSignUp() : LikedDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(LikedDaoInterface::class.java)
        }
    }

    }

