package id.ac.ubaya.informatika.ubayakost_160419017.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Account(
    @ColumnInfo(name = "username")
    var username:String,
    @ColumnInfo(name = "email")
    var email:String,
    @ColumnInfo(name = "password")
    var password:String,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber:String,
    @PrimaryKey(autoGenerate = true)
    var accountID:Int =0
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
data class KamarKost(
    @ColumnInfo(name = "fasilitas")
    var fasilitas:String,
    @ColumnInfo(name = "tipeKamar")
    var tiperKamar:String,
    @PrimaryKey(autoGenerate = false)
    var nomorKamar: String,
)