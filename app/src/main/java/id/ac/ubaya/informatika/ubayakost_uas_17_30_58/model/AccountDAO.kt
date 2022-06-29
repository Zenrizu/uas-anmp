package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model

import androidx.room.*

@Dao
interface AccountDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun register(vararg account: Account)

    @Query("SELECT * FROM account WHERE username= :username AND password= :password")
    suspend fun login(username:String, password:String): Account

    @Query("SELECT * FROM account WHERE username= :username")
    suspend fun profile(username:String): Account

    @Query("UPDATE account SET email=:email, name=:name, phoneNumber=:phoneNumber WHERE username=:username")
    suspend fun editAccount(email:String, name:String, phoneNumber: String, username: String)
}