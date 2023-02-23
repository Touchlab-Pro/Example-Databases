package co.touchlab.touchlabprodatabases.android.database

import co.touchlab.touchlabprodatabases.android.database.dao.RenewalDao

class RenewalsRepository(private val renewalDao: RenewalDao) {
    suspend fun software() = renewalDao.softwareRenewals()

    suspend fun hardware() = renewalDao.hardwareRenewals()

    suspend fun all() = renewalDao.allRenewals()
}