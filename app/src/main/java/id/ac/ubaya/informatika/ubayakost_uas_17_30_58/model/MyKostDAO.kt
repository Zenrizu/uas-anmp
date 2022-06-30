package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model

import androidx.room.*

@Dao
interface MyKostDAO{

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(vararg myKost: MyKost)

    @Query("SELECT * FROM myKost WHERE username= :username")
    suspend fun displayMyKost(username:String):MyKost

    @Delete
    suspend fun deleteMyKost(myKost: MyKost)
}