package com.example.retrocrypto0827.RetrofitClient

        import com.example.retrocrypto0827.Model.Crypto
        import io.reactivex.Observable
        import retrofit2.http.GET

        interface IMyApi {

            @GET("prices?key=b8eb02aefcc0363b01d10f26b732845d")
            fun getData(): Observable<List<Crypto>>
        }