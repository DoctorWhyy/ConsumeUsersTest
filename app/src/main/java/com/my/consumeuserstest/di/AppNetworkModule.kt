package com.my.consumeuserstest.di

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import com.my.consumeuserstest.domain.repository.UsersRepository
import com.my.consumeuserstest.domain.utlis.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppNetworkModule {

    @Singleton
    @Provides
    internal fun provideAuthenticationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    internal fun provideOkHttpClient(authenticationInterceptor: Interceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(authenticationInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    internal fun provideJacksonConverterFactory(): JacksonConverterFactory {
        val objectMapper = ObjectMapper()
        return JacksonConverterFactory
            .create(objectMapper)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        jacksonConverterFactory: JacksonConverterFactory,
        okHttpClient: OkHttpClient,
        @Named("applicationContext") context: Context
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(jacksonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): UsersRepository {
        return retrofit.create(UsersRepository::class.java)
    }
}