plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidMultiplatformLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    id("maven-publish")
}


group = "com.github.hosseinkarami-dev"
version = "1.0.0"

subprojects {
    apply(plugin = "maven-publish")

    if (project.name in listOf("app", "generator", "shared")) {
        println("⏩ Skipping publication setup for module ${project.name}")
        return@subprojects
    }

    afterEvaluate {
        extensions.configure<PublishingExtension>("publishing") {
            publications {
                create<MavenPublication>("release") {
                    from(components.findByName("release") ?: components.findByName("kotlin"))
                    groupId = rootProject.group.toString()
                    artifactId = project.name.lowercase()
                    version = rootProject.version.toString()

                    pom {
                        name.set(artifactId)
                        description.set("Awesome Android module: $artifactId")
                        url.set("https://github.com/hosseinkarami-dev/NEAR-RPC-Client-Kotlin")
                        licenses {
                            license {
                                name.set("The Apache License, Version 2.0")
                                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                            }
                        }
                        developers {
                            developer {
                                id.set("hosseinkarami-dev")
                                name.set("Hossein Karami")
                                email.set("h.karami1811@gmail.com")
                            }
                        }
                        scm {
                            connection.set("scm:git:https://github.com/hosseinkarami-dev/NEAR-RPC-Client-Kotlin.git")
                            developerConnection.set("scm:git:ssh://git@github.com/hosseinkarami-dev/NEAR-RPC-Client-Kotlin.git")
                            url.set("https://github.com/hosseinkarami-dev/NEAR-RPC-Client-Kotlin")
                        }
                    }
                }
            }
        }
    }
}