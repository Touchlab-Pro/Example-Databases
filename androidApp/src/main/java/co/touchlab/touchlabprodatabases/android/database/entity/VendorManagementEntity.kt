package co.touchlab.touchlabprodatabases.android.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "vendor_management",
    primaryKeys = ["manager", "vendor"],
    foreignKeys = [
        ForeignKey(
            entity = PeopleEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("manager")
        ),
        ForeignKey(
            entity = VendorsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("vendor")
        )
    ],
    indices = [Index("vendor"), Index("manager")]
)
data class VendorManagementEntity(
    val manager: Int,
    val vendor: Int,
    @ColumnInfo(name = "is_primary") val isPrimary: Boolean
)

