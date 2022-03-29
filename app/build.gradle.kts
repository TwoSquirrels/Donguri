/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT License, see /LICENSE file.
 */

// constants

val groupId = "com.github.twosquirrels"
val artifactId = "donguri"
val mainClassName = "$groupId.$artifactId.AppKt"

group = groupId
version = "1.0.0"

plugins {
    // Kotlin/JVM
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    // CLI
    application
}

application {
    // define main
    mainClass.set(mainClassName)
}

// tasks

task("debug", JavaExec::class) {
    mainClass.set(mainClassName)
    classpath = java.sourceSets["main"].runtimeClasspath
}

repositories {
    mavenCentral()
}

dependencies {
    // standard

    // align Kotlin versions
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    // Java8 stdlib
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // specific

    // Java Discord API
    implementation("net.dv8tion:JDA:5.0.0-alpha.9")

    // test

    // Kotlin test
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // JUnit
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
