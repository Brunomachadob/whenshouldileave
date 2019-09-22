import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "com.brunomb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.ajalt:clikt:2.0.0")
}

tasks {
    "jar"(Jar::class) {
        archiveName = "when-should-i-leave.jar"
        from(configurations.runtimeClasspath.map { if (it.isDirectory) it else zipTree(it) })
        manifest {
            attributes["Main-Class"] = "com.brunomb.whenshouldileave.WhenShouldILeaveAppKt"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}