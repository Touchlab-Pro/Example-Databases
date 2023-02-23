package co.touchlab.touchlabprodatabases

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform