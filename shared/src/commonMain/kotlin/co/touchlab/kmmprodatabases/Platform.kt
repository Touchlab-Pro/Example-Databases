package co.touchlab.kmmprodatabases

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform