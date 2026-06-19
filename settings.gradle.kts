rootProject.name = "near-jsonrpc-client"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://en-mirror.ir")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/public")
//        google {
//            mavenContent {
//                includeGroupAndSubgroups("androidx")
//                includeGroupAndSubgroups("com.android")
//                includeGroupAndSubgroups("com.google")
//            }
//        }
        google()
        mavenCentral()
        gradlePluginPortal()
        //maven { setUrl("https://maven.myket.ir") }
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://en-mirror.ir")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/public")
        maven("https://jitpack.io")
        google()
//        google {
//            mavenContent {
//                includeGroupAndSubgroups("androidx")
//                includeGroupAndSubgroups("com.android")
//                includeGroupAndSubgroups("com.google")
//            }
//        }
        mavenCentral()
        //maven { setUrl("https://maven.myket.ir") }
    }
}

include(":androidApp")
include(":shared")
include(":models")
include(":generator")
include(":client")
