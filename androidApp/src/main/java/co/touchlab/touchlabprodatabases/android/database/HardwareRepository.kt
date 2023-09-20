package co.touchlab.touchlabprodatabases.android.database

import co.touchlab.touchlabprodatabases.android.database.dao.HardwareDao
import co.touchlab.touchlabprodatabases.android.database.dao.HardwareResult
import co.touchlab.touchlabprodatabases.android.database.entity.HardwareEntity

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