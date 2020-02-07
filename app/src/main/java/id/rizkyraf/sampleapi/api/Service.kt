package id.rizkyraf.sampleapi.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

open class Service {

    val api: Api

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(provideOkHttpClient())
            .build()
        api = retrofit.create(Api::class.java)
    }

    private fun provideOkHttpClient(): OkHttpClient {
        // OkHttpClient
        return OkHttpClient.Builder()
            .connectTimeout((80 * 1000).toLong(), TimeUnit.MILLISECONDS)
            .readTimeout((80 * 1000).toLong(), TimeUnit.MILLISECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private val loggingInterceptor: HttpLoggingInterceptor
        get() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    interface Api {

        @GET("siswa")
        fun login(): Call<List<SiswaBeans>>
    }

    companion object {
        private const val URL_PROD = "https://yapri.rizkyraf.id/api/"

        /**/
        private const val URL = URL_PROD
        private const val BASE_URL = URL
    }
}
