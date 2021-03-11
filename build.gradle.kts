plugins{
    id("maven-publish")
    java
    kotlin("multiplatform") version "1.4.31"
    id("java-library")
}

group = "org.learning"
version = "1.0.6"

repositories {
    mavenCentral()
}

kotlin {
    targets {
        js {
//            binaries.library()
            nodejs {
                compilations.all {
                    packageJson {
                        private = false
                    }
                }
            }
        }

        jvm {
            compilations.all {
                kotlinOptions.jvmTarget = "1.8"
            }
            testRuns["test"].executionTask.configure {
                useJUnitPlatform()
            }
        }
    }

    sourceSets {
        val kotestVersion = "4.4.3"

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }

        val jvmMain by getting {
            dependsOn(commonMain)
        }

        val commonTest by getting {
            dependencies {
                implementation("io.kotest:kotest-framework-api:$kotestVersion")
                implementation("io.kotest:kotest-assertions-core:$kotestVersion")
            }

        }

        val jsTest by getting {
            dependencies {
                implementation("io.kotest:kotest-framework-engine:$kotestVersion")
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation("io.kotest:kotest-runner-junit5:$kotestVersion")
            }
        }

    }
}

tasks.named<org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile>("compileKotlinJs").configure {
    kotlinOptions.moduleKind = "commonjs"
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
    filter {
        isFailOnNoMatchingTests = false
    }
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

publishing {

    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
