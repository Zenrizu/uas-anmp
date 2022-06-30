package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.accountDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.KostDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.URL
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
            val TAG = "myactivity"
            Log.d(TAG, kostLiveData.value.toString())
        }
    }

    fun insertData(kost: List<Kost>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                KostDatabase::class.java, "kostDBase").build()

            db.kostDao().addKost(*kost.toTypedArray())
        }
    }
}