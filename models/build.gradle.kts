@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    js {
        browser()
    }
    wasmJs {
        browser()
        nodejs()
    }
    jvm()
    iosArm64()
    iosSimulatorArm64()
    macosArm64()
    linuxX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        jvmTest.dependencies {
            implementation(libs.junit)
            implementation(libs.junit.jupiter.api)
            implementation(libs.junit.jupiter.engine)
        }
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}
