package cl.armin20.ejemploinacap.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofit {
    companion object {
        private const val BASE_URL = "https://board-games-fake-api.herokuapp.com/"
        fun retrofitInstance(): BoardApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BoardApi::class.java)
        }
    }
}