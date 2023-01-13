package co.touchlab.kmmprodatabases.android.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "departments")
data class DepartmentsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)