package co.touchlab.touchlabprodatabases.android.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "people",
    foreignKeys = [
        ForeignKey(
            entity = RolesEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("role")
        ),
        ForeignKey(
            entity = DepartmentsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("department")
        ),
    ],
    indices = [Index("role"), Index("department")]
)
data class PeopleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val role: Int,
    val department: Int
)