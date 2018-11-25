package co.vladanjovanovic.kroontask.di.network

import co.vladanjovanovic.kroontask.data.model.FeedType
import co.vladanjovanovic.kroontask.data.network.FeedService
import co.vladanjovanovic.kroontask.utils.DateDeserializer
import co.vladanjovanovic.kroontask.utils.FeedTypeDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()

    @Provides
    @Singleton
    fun provideDateAdapter(): DateDeserializer = DateDeserializer()

    @Provides
    @Singleton
    fun provideFeedTypeDeserializer(): FeedTypeDeserializer = FeedTypeDeserializer()

    @Provides
    @Singleton
    fun provideGson(dateDeserializer: DateDeserializer, feedTypeDeserializer: FeedTypeDeserializer): Gson =
        GsonBuilder()
            .registerTypeAdapter(Date::class.java, dateDeserializer)
            .registerTypeAdapter(FeedType::class.java, feedTypeDeserializer)
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): FeedService = retrofit.create(FeedService::class.java)

    companion object {
        const val BASE_URL: String = " http://kroon-feed.jarovid.com"
    }
}