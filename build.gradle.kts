import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("io.ktor.plugin") version "2.2.1"
    application
}

group = "ru.pozitp"
version = "1.0-SNAPSHOT"

repositories {
    maven(url="https://jitpack.io")
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.slf4j:slf4j-simple:2.0.5")
    implementation("com.github.ev3dev-lang-java:ev3dev-lang-java:2.6.2-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "18"
}

application {
    mainClass.set("MainKt")
}


//Jar
tasks.jar {
    baseName = rootProject.name
    manifest{
        file("${projectDir}/src/main/resources/META-INF/MANIFEST.MF")
    }
}

/*tasks.fatJar {
    doLast {
    }
}*/

/*
ktor {
    fatJar {

    }
}

apply(from= "./config.gradle")
apply(from= "./gradle/deploy.gradle")*/
