package ru.skillbranch.gameofthrones.di

import androidx.lifecycle.Lifecycle
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.BuildConfig
import ru.skillbranch.gameofthrones.data.network.IHousesApi
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    @Named(WITHOUT_AUTH_CLIENT)
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()


    @Provides
    @Singleton
    @Named(WITHOUT_AUTH_RETROFIT)
    fun provideRetrofit(gson: Gson, @Named(WITHOUT_AUTH_CLIENT) okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideHousesApi(@Named(WITHOUT_AUTH_RETROFIT) retrofit: Retrofit) : IHousesApi =
        retrofit.create(IHousesApi::class.java)

    companion object {
        private const val AUTH_CLIENT = "auth_client"
        private const val WITHOUT_AUTH_CLIENT = "without_auth_client"
        private const val AUTH_RETROFIT = "auth_retrofit"
        private const val WITHOUT_AUTH_RETROFIT = "without_auth_retrofit"
    }
}