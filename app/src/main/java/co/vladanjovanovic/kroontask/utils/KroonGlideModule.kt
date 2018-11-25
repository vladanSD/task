package co.vladanjovanovic.kroontask.utils

import android.content.Context
import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.di.app.DaggerApplicationComponent
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import okhttp3.OkHttpClient
import java.io.InputStream
import javax.inject.Inject

@GlideModule(glideName = "KroonGlide")
class KroonGlideModule : AppGlideModule() {
    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        ((context.applicationContext as KroonApp).injector as DaggerApplicationComponent).inject(this)
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(okHttpClient))
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val requestOptions =
            RequestOptions().format(DecodeFormat.PREFER_ARGB_8888).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
        builder.setDefaultRequestOptions(requestOptions)
        builder.setMemoryCache(LruResourceCache(10 * 1024 * 1024))
    }
}