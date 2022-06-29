package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.accountDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.AccountDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AccountViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val accountLD = MutableLiveData<List<Account>>()
    val accountLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val db = accountDb(getApplication())

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun login(username:String, password:String) {
        loadingLD.value = true
        accountLoadErrorLD.value = false
        launch {
            accountLD.value = listOf(db.accountDao().login(username, password))
        }
    }

    fun register(list: List<Account>){
        launch {
            db.accountDao().register(*list.toTypedArray())
        }
    }

    fun editAccount(list: List<Account>){
        launch {
            db.accountDao().editAccount(*list.toTypedArray())
        }
    }

}