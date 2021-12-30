plugins {
    id(Android.plugins_library)
    id(Kotlin.plugins_android)
    id(Kotlin.plugins_kapt)
    id(Kotlin.plugins_parcelize)
    id(Maven.public)
}

group = "com.D10NG"
version = "1.0.0"

android {
    compileSdk = Android.compile_sdk

    defaultConfig {
        minSdk = Android.min_sdk
        targetSdk = Android.target_sdk

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
        jvmTarget = Kotlin.jvm_target
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.version
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Android
    implementation(Android.androidx_core)
    implementation(Android.androidx_appcompat)
    implementation(Android.google_material)

    // 单元测试（可选）
    testImplementation(Test.junit)

    // Compose
    implementation(Compose.androidx_ui)
    implementation(Compose.androidx_tooling)
    implementation(Compose.androidx_foundation)
    implementation(Compose.androidx_material)
    implementation(Compose.activity)
    implementation(Compose.livedata)
    implementation(Compose.androidx_navigation)

    // Lifecycle
    implementation(Lifecycle.runtime)
    implementation(Lifecycle.compiler)
    implementation(Lifecycle.compose_viewmodel_support)
    implementation(Lifecycle.livedata_support)

    // Coroutines
    implementation(Kotlin.coroutines_core)
    implementation(Kotlin.coroutines_android)
}