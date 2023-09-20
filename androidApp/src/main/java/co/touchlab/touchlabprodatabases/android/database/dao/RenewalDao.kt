package co.touchlab.touchlabprodatabases.android.database.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Query

@Dao
abstract class RenewalDao {
    @Query(
        """
        SELECT s.vendor, s.license_end_date AS renewal_date, s.name, 'SOFTWARE' AS type, p.name AS manager, v.name as vendor_name 
        FROM software AS s 
        JOIN vendor_management vm ON s.vendor = vm.vendor AND vm.is_primary = 1 
        JOIN vendorsentity v ON vm.vendor = v.id 
        JOIN people p ON p.id = vm.manager
    """
    )
    abstract fun softwareRenewals(): List<Renewal>

    @Query(
        """
        SELECT h.vendor, h.replacement_date AS renewal_date, h.name, 'HARDWARE' AS type, p.name AS manager, v.name as vendor_name 
        FROM hardware AS h 
        JOIN vendor_management vm ON h.vendor = vm.vendor AND vm.is_primary = 1 
        JOIN vendorsentity v ON vm.vendor = v.id 
        JOIN people p ON p.id = vm.manager
    """
    )
    abstract fun hardwareRenewals(): List<Renewal>

    @Query("""
        SELECT s.vendor, s.license_end_date AS renewal_date, s.name, 'SOFTWARE' AS type, p.name AS manager, v.name as vendor_name 
        FROM software AS s 
        JOIN vendor_management vm ON s.vendor = vm.vendor AND vm.is_primary = 1 
        JOIN vendorsentity v ON vm.vendor = v.id 
        JOIN people p ON p.id = vm.manager
        UNION
        SELECT h.vendor, h.replacement_date AS renewal_date, h.name, 'HARDWARE' AS type, p.name AS manager, v.name as vendor_name 
        FROM hardware AS h 
        JOIN vendor_management vm ON h.vendor = vm.vendor AND vm.is_primary = 1 
        JOIN vendorsentity v ON vm.vendor = v.id 
        JOIN people p ON p.id = vm.manager
    """)
    abstract fun allRenewals(): List<Renewal>
}

data class Renewal(
    val vendor: Int,
    @ColumnInfo(name = "renewal_date") val renewalDate: Long,
    val name: String,
    val type: RenewalType,
    val manager: String,
    @ColumnInfo(name = "vendor_name") val vendorName: String
)

enum class RenewalType {
    SOFTWARE, HARDWARE
}
