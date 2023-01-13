package co.touchlab.kmmprodatabases.android.database.dao

import androidx.room.*
import co.touchlab.kmmprodatabases.android.database.entity.HardwareEntity
import co.touchlab.kmmprodatabases.android.database.entity.VendorsEntity

@Dao
interface HardwareDao {
    @Query("select * from hardware")
    @Transaction
    fun getAll(): List<HardwareResult>

    @Insert
    fun create(vararg hardware: HardwareEntity)

    @Query("delete from hardware where id=:id")
    fun delete(id: Int)
}

data class HardwareResult(
    @Embedded val hardware: HardwareEntity,
    @Relation(parentColumn = "vendor", entityColumn = "id")
    val vendor: VendorsEntity
)
