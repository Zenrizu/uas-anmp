package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost

class DetailViewModel(application: Application): AndroidViewModel(application) {
        val kostLiveData = MutableLiveData<Kost>()
        private var queue: RequestQueue? = null

        fun fetch(id: String) {

            queue = Volley.newRequestQueue(getApplication())
            val url = "https://api.npoint.io/e6260fcf7e8aecbe6381/$id"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
                    val result = Gson().fromJson<Kost>(it, Kost::class.java)
                    kostLiveData.value = result
                    Log.d("Show volley: ", result.toString())
                },
                {
                    Log.d("Show volley: ", it.toString())
                }
            ).apply {
                tag = "TAG"
            }
            queue?.add(stringRequest)

        }

}
