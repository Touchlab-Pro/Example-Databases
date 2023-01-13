package co.touchlab.kmmprodatabases.android.database

import co.touchlab.kmmprodatabases.android.database.dao.RenewalDao

class RenewalsRepository(private val renewalDao: RenewalDao) {
    suspend fun software() = renewalDao.softwareRenewals()

    suspend fun hardware() = renewalDao.hardwareRenewals()

    suspend fun all() = renewalDao.allRenewals()
}