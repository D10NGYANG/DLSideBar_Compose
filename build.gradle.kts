// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(Android.classpath_gradle)
        classpath(Kotlin.classpath_gradle)
        classpath(Kotlin.classpath_serialization)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(Maven.jitpack)
    }
}

tasks.register<Delete>(name = "clean") {
    group = "build"
    delete(rootProject.buildDir)
}