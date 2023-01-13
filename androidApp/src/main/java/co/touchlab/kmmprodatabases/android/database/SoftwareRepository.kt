package co.touchlab.kmmprodatabases.android.database

import co.touchlab.kmmprodatabases.android.database.dao.SoftwareDao
import co.touchlab.kmmprodatabases.android.database.dao.SoftwareResult
import co.touchlab.kmmprodatabases.android.database.entity.SoftwareEntity

class SoftwareRepository(private val softwareDao: SoftwareDao) {
    suspend fun allSoftware(): List<SoftwareResult> {
        return softwareDao.getAll()
    }

    suspend fun create(name: String, vendorId: Int, licenseStart: Long, licenseEnd: Long) {
        softwareDao.create(SoftwareEntity(0, licenseStart, licenseEnd, name, vendorId))
    }

    suspend fun delete(id: Int) {
        softwareDao.delete(id)
    }
}