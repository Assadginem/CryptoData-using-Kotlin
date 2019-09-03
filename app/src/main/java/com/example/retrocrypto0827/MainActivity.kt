package com.example.retrocrypto0827

        import androidx.appcompat.app.AppCompatActivity
        import android.os.Bundle
        import androidx.recyclerview.widget.LinearLayoutManager
        import com.example.retrocrypto0827.Adapter.CryptoAdapter
        import com.example.retrocrypto0827.Model.Crypto
        import com.example.retrocrypto0827.RetrofitClient.IMyApi
        import com.example.retrocrypto0827.RetrofitClient.RetrofitClient
        import io.reactivex.android.schedulers.AndroidSchedulers
        import io.reactivex.disposables.CompositeDisposable
        import io.reactivex.schedulers.Schedulers
        import kotlinx.android.synthetic.main.activity_main.*

        class MainActivity : AppCompatActivity() {


            private lateinit var jsonApi: IMyApi
            private var compositeDisposable: CompositeDisposable = CompositeDisposable()


            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                // Init api
                val retrofit = RetrofitClient.instance
                jsonApi = retrofit.create(IMyApi::class.java)

                // View
                recycler_crypto.layoutManager = LinearLayoutManager(this)
                recycler_crypto.setHasFixedSize(true)
                fetchData()
            }

            private fun fetchData() {
                compositeDisposable.add(jsonApi.getData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {displayData(it)})
            }

            private fun displayData(cryptoList: List<Crypto>) {
                val adapter = CryptoAdapter(this, cryptoList)
                recycler_crypto.adapter = adapter
            }
        }
