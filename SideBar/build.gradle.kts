plugins {
    id(Android.Plugin.library)
    id(Kotlin.Plugin.ID.android)
    id(Kotlin.Plugin.ID.kapt)
    id(Kotlin.Plugin.ID.parcelize)
    id(Maven.Plugin.public)
}

group = "com.github.D10NG"
version = "1.0.3"

android {
    compileSdk = Project.compile_sdk

    defaultConfig {
        minSdk = Project.min_sdk
        targetSdk = Project.target_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_ver
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Android
    implementation(AndroidX.core_ktx("1.7.0"))
    implementation(AndroidX.appcompat("1.4.1"))
    implementation(Android.Google.material("1.5.0"))

    // 单元测试（可选）
    testImplementation(Test.junit("4.13.2"))
    androidTestImplementation(AndroidX.Test.junit("1.1.3"))
    androidTestImplementation(AndroidX.Test.espresso_core("3.4.0"))

    // Compose
    implementation(AndroidX.Compose.ui(compose_ver))
    androidTestImplementation(AndroidX.Compose.ui_test(compose_ver))
    implementation(AndroidX.Compose.ui_tooling(compose_ver))
    implementation(AndroidX.Compose.foundation(compose_ver))
    implementation(AndroidX.Compose.animation(compose_ver))
    implementation(AndroidX.Compose.material(compose_ver))
    implementation(AndroidX.Compose.material_icons_core(compose_ver))
    implementation(AndroidX.Compose.material_icons_extended(compose_ver))
    implementation(AndroidX.Compose.runtime_livedata(compose_ver))
    implementation(AndroidX.activity_compose("1.4.0"))
    implementation(AndroidX.navigation_compose("2.4.1"))

    // Lifecycle
    implementation(AndroidX.Lifecycle.runtime_ktx(jetpack_lifecycle_ver))
    implementation(AndroidX.Lifecycle.common_java8((jetpack_lifecycle_ver)))
    implementation(AndroidX.Lifecycle.viewmodel_compose_support(jetpack_lifecycle_ver))
    implementation(AndroidX.Lifecycle.livedata_ktx_support(jetpack_lifecycle_ver))

    // Coroutines
    implementation(Kotlin.Coroutines.core(kotlin_coroutines_ver))
    implementation(Kotlin.Coroutines.android(kotlin_coroutines_ver))
}

afterEvaluate {
    publishing {
        publications {
            create(Publish.release, MavenPublication::class) {
                from(components.getByName(Publish.release))
            }
        }
    }
}