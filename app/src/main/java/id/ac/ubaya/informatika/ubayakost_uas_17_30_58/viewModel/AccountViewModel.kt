package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.kostDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AccountViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val accountLD = MutableLiveData<Account>()
    var result = ""

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun login(username:String, password:String) {
        launch {
            val db = kostDb(getApplication())//pemanggilan database dari util
            if (username != "" && password != "" || username != accountLD.value?.username && password != accountLD.value?.password) {
                result = "Failed"
                Log.d("Global", "no")
            } else {
                result = "Success"
                Log.d("Global", "ok")
            }
            accountLD.value = db.accountDao().login(username, password)
        }
    }

    fun profile(username: String) {
        launch {
            val db = kostDb(getApplication())
            accountLD.value=db.accountDao().profile(username)
//            db.accountDao().profile(username)
        }
    }

    fun register(account: Account) {
        launch {
            val db = kostDb(getApplication())
            db.accountDao().register(account)
        }
    }

    fun editAccount(email: String, name: String, phoneNumber: String, username: String) {
        launch {
            val db = kostDb(getApplication())
            db.accountDao().editAccount(email, name, phoneNumber, username)
        }
    }
}
