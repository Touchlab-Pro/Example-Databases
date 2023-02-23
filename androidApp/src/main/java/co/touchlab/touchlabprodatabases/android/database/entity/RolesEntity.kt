package co.touchlab.touchlabprodatabases.android.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roles")
data class RolesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)