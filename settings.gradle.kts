pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://raw.githubusercontent.com/D10NGYANG/maven-repo/main/repository")
        maven("https://jitpack.io")
    }
}
rootProject.name = "DLSideBar_Compose"
include("app", "library")
