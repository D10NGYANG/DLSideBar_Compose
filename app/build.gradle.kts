plugins {
    id(Android.plugins_application)
    id(Kotlin.plugins_android)
    id(Kotlin.plugins_kapt)
    id(Kotlin.plugins_parcelize)
    id(Kotlin.plugins_serialization)
}

android {
    compileSdk = Android.compile_sdk

    defaultConfig {
        applicationId = "com.d10ng.sidebar.demo"
        minSdk = Android.min_sdk
        targetSdk = Android.target_sdk
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation(project(":SideBar"))

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

    // Compose 拓展
    implementation(Accompanist.insets)
    implementation(Accompanist.insets_ui)
    implementation(Accompanist.systemuicontroller)
    implementation(Accompanist.swiperefresh)
    implementation(Accompanist.navigation_animation)

    // Lifecycle
    implementation(Lifecycle.runtime)
    implementation(Lifecycle.compiler)
    implementation(Lifecycle.compose_viewmodel_support)
    implementation(Lifecycle.livedata_support)

    // Coroutines
    implementation(Kotlin.coroutines_core)
    implementation(Kotlin.coroutines_android)

    // kotlinx.serialization
    implementation(Kotlin.serialization_json)

    // 协程封装工具
    implementation(D10NG.coroutinesUtil)
    // APP通用工具
    implementation(D10NG.appUtil)

    // 拼音处理
    implementation(files("libs/pinyin4j-2.5.0.jar"))
}