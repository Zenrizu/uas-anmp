package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = (supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)
        bottomNav.setupWithNavController(navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
//    }
    override fun onSupportNavigateUp(): Boolean {
        //kalo null back button itu ke stack sebelumnya
        //dikarenakan ada drawer layout,maka ditambahkan drawerlayout
        //
        return super.onSupportNavigateUp()
//        return NavigationUI.navigateUp(navController,drawerLayout) || super.onSupportNavigateUp()//nambah drawer layout untuk side bar
    }
//    override fun onBackPressed() {
//        val intent = Intent(Intent.ACTION_MAIN)//akses home
//        intent.addCategory(Intent.CATEGORY_HOME)//menambah kategori home agar ketika di back langsung menuju home
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP//menghapus history activity yang dibuka
//        startActivity(intent)
//    }
}