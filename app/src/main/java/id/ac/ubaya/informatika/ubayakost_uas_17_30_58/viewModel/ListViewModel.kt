package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.kostDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.KostDatabase
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.MyKost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val kostLiveData = MutableLiveData<List <Kost>>()
    val kostLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun display() {
        kostLoadErrorLiveData.value = false
        loadingLiveData.value = true

        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                KostDatabase::class.java, "kostDBase").build()

            kostLiveData.value = db.kostDao().displayKost()
        }
    }

    fun booking(myKost: MyKost) {
        launch {
            val db = kostDb(getApplication())
            db.myKostDAO().book(myKost)
        }
    }
}