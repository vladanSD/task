package co.vladanjovanovic.kroontask.di.app

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.RoomDatabase
import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.data.Repository
import co.vladanjovanovic.kroontask.data.network.FeedService
import co.vladanjovanovic.kroontask.di.network.NetworkModule.Companion.BASE_URL
import co.vladanjovanovic.kroontask.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: KroonApp): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideFeedService(retrofit: Retrofit): FeedService = retrofit.create(FeedService::class.java)

    @Provides
    @Singleton
    fun provideRepository(feedService: FeedService, database: RoomDatabase) : Repository = Repository(feedService, database)

    @Provides
    @Singleton
    fun getViewModelFactory(repository: Repository): ViewModelProvider.Factory =
        ViewModelFactory(repository)
}
