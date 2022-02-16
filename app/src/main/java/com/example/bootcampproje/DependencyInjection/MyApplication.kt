package com.example.bootcampproje.DependencyInjection

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.bootcampproje.api.RetrofitApi
import com.example.bootcampproje.util.URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyApplication : Application()  {

    @Singleton
    @Provides
    fun provideAnalyticsService(
    ): RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }

    @Singleton
    @Provides
    fun provideGlide(@ActivityContext context: Context): RequestManager  {
        return Glide
            .with(context)
            /*.load("http://via.placeholder.com/300.png")
            .centerCrop()
            .into(ivImg);*/
    }

}