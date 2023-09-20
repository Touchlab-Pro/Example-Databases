package co.touchlab.touchlabprodatabases.android.database.entity

import androidx.room.*

@Entity(
    tableName = "hardware",
    foreignKeys = [
        ForeignKey(
            entity = VendorsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("vendor")
        )
    ],
    indices = [Index("vendor")]
)
data class HardwareEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    @ColumnInfo(name = "ip_address") val ipAddress: String,
    @ColumnInfo(name = "install_date") val installDate: Long,
    @ColumnInfo(name = "replacement_date") val replacementDate: Long,
    val vendor: Int
)