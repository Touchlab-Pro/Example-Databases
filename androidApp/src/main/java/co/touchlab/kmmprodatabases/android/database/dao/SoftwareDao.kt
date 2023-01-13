package co.touchlab.kmmprodatabases.android.database.dao

import androidx.room.*
import co.touchlab.kmmprodatabases.android.database.entity.SoftwareEntity
import co.touchlab.kmmprodatabases.android.database.entity.VendorsEntity

@Dao
interface SoftwareDao {
    @Query("select * from software")
    @Transaction
    fun getAll(): List<SoftwareResult>

    @Insert
    fun create(vararg software: SoftwareEntity)

    @Query("delete from software where id=:id")
    fun delete(id: Int)
}

data class SoftwareResult(
    @Embedded val software: SoftwareEntity,
    @Relation(parentColumn = "vendor", entityColumn = "id")
    val vendor: VendorsEntity
)
