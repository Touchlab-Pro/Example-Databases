plugins {
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.kapt)
}

kotlin {
    androidTarget {}
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        iosMain {
        }
        iosTest {
        }
    }
}

android {
    namespace = "co.touchlab.touchlabprodatabases"
    compileSdk = 35
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

sqldelight {
    database("AssetManagementDatabase") {
        packageName = "co.touchlab.touchlabprodatabases"
        version = 1
    }
}