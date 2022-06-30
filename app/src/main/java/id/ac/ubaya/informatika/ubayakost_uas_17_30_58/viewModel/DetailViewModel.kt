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
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.accountDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.MyKost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
        val kostLiveData = MutableLiveData<Kost>()
        private var queue: RequestQueue? = null
        private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job+Dispatchers.Main
        fun fetch(id: String) {

            val db = accountDb(getApplication())
//            kostLiveData.value = db.kostDao().detailKost(id)


//            queue = Volley.newRequestQueue(getApplication())
//            val url = "https://api.npoint.io/e6260fcf7e8aecbe6381/$id"
//
//            val stringRequest = StringRequest(
//                Request.Method.GET, url,
//                {
//                    val result = Gson().fromJson<Kost>(it, Kost::class.java)
//                    kostLiveData.value = result
//                    Log.d("Show volley: ", result.toString())
//                },
//                {
//                    Log.d("Show volley: ", it.toString())
//                }
//            ).apply {
//                tag = "TAG"
//            }
//            queue?.add(stringRequest)

        }
        fun booking(myKost: MyKost) {
            launch {
                val db = accountDb(getApplication())
                db.myKostDAO().insert(myKost)
            }
        }

}
