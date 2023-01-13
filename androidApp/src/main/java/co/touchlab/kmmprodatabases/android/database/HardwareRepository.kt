package co.touchlab.kmmprodatabases.android.database

import co.touchlab.kmmprodatabases.android.database.dao.HardwareDao
import co.touchlab.kmmprodatabases.android.database.dao.HardwareResult
import co.touchlab.kmmprodatabases.android.database.dao.SoftwareResult
import co.touchlab.kmmprodatabases.android.database.entity.HardwareEntity
import co.touchlab.kmmprodatabases.android.database.entity.SoftwareEntity

class HardwareRepository(private val hardwareDao: HardwareDao) {
    suspend fun allHardware(): List<HardwareResult> {
        return hardwareDao.getAll()
    }

    suspend fun create(name: String, vendorId: Int, ipAddress:String,installDate: Long, replacementDate:Long) {
        hardwareDao.create(HardwareEntity(0, name, ipAddress, installDate, replacementDate, vendorId))
    }

    suspend fun delete(id: Int) {
        hardwareDao.delete(id)
    }
}