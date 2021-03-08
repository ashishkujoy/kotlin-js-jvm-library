plugins {
    java
    kotlin("multiplatform") version "1.4.31"
    id("java-library")
}

group = "org.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    targets {
        js {
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


