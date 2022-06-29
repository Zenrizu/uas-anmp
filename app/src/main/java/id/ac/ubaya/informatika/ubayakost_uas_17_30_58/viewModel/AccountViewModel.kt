package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.accountDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AccountViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val accountLD = MutableLiveData<List<Account>>()
    val accountDetailLD = MutableLiveData<Account>()
    val accountLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun login(username:String, password:String) {

        loadingLD.value = true
        accountLoadErrorLD.value = false
        launch {
            val db = accountDb(getApplication())
            accountLD.value = listOf(db.accountDao().login(username, password))
        }
    }

    fun profile(username: String){
        loadingLD.value = true
        accountLoadErrorLD.value = false
        launch {
            val db = accountDb(getApplication())
            db.accountDao().profile(username)
        }
    }

    fun register(list: List<Account>){
        launch{
            val db = accountDb(getApplication())
            db.accountDao().register(*list.toTypedArray())
        }
    }

    fun editAccount(email:String, name:String, phoneNumber: String, username: String){
        launch {
            val db = accountDb(getApplication())
            db.accountDao().editAccount(email, name, phoneNumber, username)
        }
    }

}