package co.touchlab.touchlabprodatabases.android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.touchlab.touchlabprodatabases.android.database.dao.HardwareDao
import co.touchlab.touchlabprodatabases.android.database.dao.RenewalDao
import co.touchlab.touchlabprodatabases.android.database.dao.SoftwareDao
import co.touchlab.touchlabprodatabases.android.database.entity.*

@Database(
    entities = [
        DepartmentsEntity::class,
        RolesEntity::class,
        PeopleEntity::class,
        HardwareEntity::class,
        SoftwareEntity::class,
        VendorsEntity::class,
        VendorManagementEntity::class
    ],
    version = 1
)
abstract class AssetManagementDatabase : RoomDatabase() {
    abstract fun softwareDao(): SoftwareDao
    abstract fun HardwareDao(): HardwareDao
    abstract fun renewalDao(): RenewalDao
}