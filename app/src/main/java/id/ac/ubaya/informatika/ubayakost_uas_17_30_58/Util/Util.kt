package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.KostDatabase
import java.lang.Exception
import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun ImageView.loadImage(url: String?,progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_location_on_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) { }

        })
}

val DB_KOST = "kostDBase"

fun kostDb(context: Context):KostDatabase {
    val db = Room.databaseBuilder(context, KostDatabase::class.java, DB_KOST).build()
    return db
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoURL(view: ImageView, url: String?, progressBar: ProgressBar) {
    view.loadImage(url, progressBar)
}