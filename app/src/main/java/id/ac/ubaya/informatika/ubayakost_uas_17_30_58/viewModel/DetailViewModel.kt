package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.kostDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.MyKost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
        val kostLiveData = MutableLiveData<Kost>()
//        private var queue: RequestQueue? = null
        private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job+Dispatchers.Main
    fun fetch(id:String) {
        launch{
            val db = kostDb(getApplication())//pemanggilan database
            kostLiveData.value = db.kostDao().detailKost(id)
        }

    }
    fun booking(myKost: MyKost) {
        launch {
            val db = kostDb(getApplication())
            db.myKostDAO().insert(myKost)
        }
    }

}
