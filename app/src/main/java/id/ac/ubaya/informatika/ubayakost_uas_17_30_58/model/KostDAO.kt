package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model

import androidx.room.*

@Dao
interface KostDAO {
    @Query("SELECT * FROM kost")
    suspend fun displayKost(): List<Kost>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addKost(vararg kost: Kost)
}