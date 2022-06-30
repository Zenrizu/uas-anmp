package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view.ButtonSaveRegisterListener
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view.FragmentMyKost

@Entity
data class Account(
    @PrimaryKey(autoGenerate = false)
    var username:String,
    @ColumnInfo(name = "email")
    var email:String,
    @ColumnInfo(name = "password")
    var password:String,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber:String
)

@Entity
data class Kost(
    @ColumnInfo(name = "namaKost")
    var namaKost: String,
    @ColumnInfo(name = "deskripsi")
    var deskripsi: String,
    @ColumnInfo(name = "tipeKost")
    var tipeKost: String,
    @ColumnInfo(name = "alamat")
    var alamat:String,
    @ColumnInfo(name = "harga")
    var harga:String,
    @ColumnInfo(name = "telepon")
    var telepon:String,
    @ColumnInfo(name = "pemilik")
    var pemilik:String,
    @ColumnInfo(name = "rekening")
    var rekening:String,
    @ColumnInfo(name = "foto")
    var foto:String,
    @PrimaryKey(autoGenerate = true)
    var idKost: Int,
)

@Entity
data class MyKost(
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "idKost")
    var idKost: Int,
    @PrimaryKey(autoGenerate = false)
    var idMyKost: String
)