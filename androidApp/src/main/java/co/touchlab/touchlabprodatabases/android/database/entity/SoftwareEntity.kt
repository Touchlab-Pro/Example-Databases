package co.touchlab.touchlabprodatabases.android.database.entity

import androidx.room.*

@Entity(
    tableName = "software",
    foreignKeys = [
        ForeignKey(
            entity = VendorsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("vendor")
        )
    ],
    indices = [Index("vendor")]
)
data class SoftwareEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "license_start_date") val licenseStartDateDate: Long,
    @ColumnInfo(name = "license_end_date") val licenseEndDate: Long,
    val name: String,
    val vendor: Int
)