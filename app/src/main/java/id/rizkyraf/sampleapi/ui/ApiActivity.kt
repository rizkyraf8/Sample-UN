package id.rizkyraf.sampleapi.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.rizkyraf.sampleapi.R
import id.rizkyraf.sampleapi.api.Service
import id.rizkyraf.sampleapi.api.SiswaBeans
import id.rizkyraf.sampleapi.ui.adapter.SiswaAdapter
import kotlinx.android.synthetic.main.activity_api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiActivity : AppCompatActivity() {

    private val mAdapter by lazy {
        val list = ArrayList<SiswaBeans>()
        SiswaAdapter(this, list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        loadData()
    }

    private fun loadData() {
        val api = Service().api
        api.login().enqueue(object :
            Callback<List<SiswaBeans>> {
            override fun onResponse(
                call: Call<List<SiswaBeans>>,
                response: Response<List<SiswaBeans>>
            ) {
                if (response.isSuccessful) {
                    setAdapter(response.body())
                } else {
                    Toast.makeText(this@ApiActivity, response.message(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<SiswaBeans>>, t: Throwable) {
                Toast.makeText(this@ApiActivity, t.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    fun setAdapter(response: List<SiswaBeans>?) {
        rvData.layoutManager = LinearLayoutManager(this)
        rvData.adapter = mAdapter
        rvData.isNestedScrollingEnabled = true

        if (response != null) {
            mAdapter.reCreate(response)
        }

    }
}
