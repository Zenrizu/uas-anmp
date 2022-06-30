package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.kostDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.MyKost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MyKostViewModel(application: Application): AndroidViewModel(application),CoroutineScope {

    val myKostLiveData = MutableLiveData<MyKost>()//live data
    val loadingErrorKuLD = MutableLiveData<Boolean>()
    val loadingKuLD= MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun cancelBook(myKost: MyKost) {
        launch {
            val db = kostDb(getApplication())
            db.myKostDAO().deleteMyKost(myKost)
        }
    }

    fun displayMyKost(username: String) {
        loadingKuLD.value = true
        loadingErrorKuLD.value = false
        launch {
            val db = kostDb(getApplication())
            myKostLiveData.value = db.myKostDAO().displayMyKost(username)
        }
    }

}