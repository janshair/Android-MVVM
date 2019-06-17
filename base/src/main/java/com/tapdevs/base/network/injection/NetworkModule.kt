package com.tapdevs.base.network.injection

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tapdevs.base.BuildConfig
import com.tapdevs.base.injection.qualifiers.NamedScheduler
import com.tapdevs.base.injection.scopes.PerApplication
import com.tapdevs.base.network.api.MealCAtegoryApi
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @PerApplication
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Provides
    @PerApplication
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @PerApplication
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Provides
    @PerApplication
    @NamedScheduler(NamedScheduler.SchedulerType.IO)
    fun provideScheduler(): Scheduler = Schedulers.io()

    @Provides
    @PerApplication
    @NamedScheduler(NamedScheduler.SchedulerType.UI)
    fun provideMainScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @PerApplication
    fun provideGsonConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @PerApplication
    fun provideAlbumRestApi(retrofit: Retrofit): MealCAtegoryApi = retrofit.create(MealCAtegoryApi::class.java)

    @Provides
    @PerApplication
    fun provideGson(): Gson {
        return GsonBuilder()
                .create()
    }

    @Provides
    @PerApplication
    fun provideAlbumsApi(builder: Retrofit.Builder, okHttpClientBuilder: OkHttpClient.Builder, httpLoggingInterceptor: HttpLoggingInterceptor, converterFactory: Converter.Factory): Retrofit {
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
        }
        return builder
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(converterFactory)
                .build()
    }
}