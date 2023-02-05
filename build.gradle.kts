plugins {
    kotlin("js") version "1.8.0"
}

group = "me.james"
version = "1.0-SNAPSHOT"

val ktor_version = "2.2.3"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.2")
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}

kotlin {
    js {
        binaries.executable()
        browser {
            testTask {
                useMocha {
                    timeout = "10s"
                }
            }
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
}