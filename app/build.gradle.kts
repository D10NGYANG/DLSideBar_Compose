plugins {
    id(Android.Plugin.application)
    id(Kotlin.Plugin.ID.android)
    id(Kotlin.Plugin.ID.kapt)
    id(Kotlin.Plugin.ID.parcelize)
    id(Kotlin.Plugin.ID.serialization)
}

android {
    compileSdk = Project.compile_sdk

    defaultConfig {
        applicationId = "com.d10ng.sidebar.demo"
        minSdk = Project.min_sdk
        targetSdk = Project.target_sdk
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
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_ver
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

    // Compose 拓展
    implementation(Accompanist.insets(accompanist_ver))
    implementation(Accompanist.insets_ui(accompanist_ver))
    implementation(Accompanist.systemuicontroller(accompanist_ver))
    implementation(Accompanist.appcompat_theme(accompanist_ver))
    implementation(Accompanist.pager(accompanist_ver))
    implementation(Accompanist.pager_indicators(accompanist_ver))
    implementation(Accompanist.swiperefresh(accompanist_ver))
    implementation(Accompanist.placeholder(accompanist_ver))
    implementation(Accompanist.placeholder_material(accompanist_ver))
    implementation(Accompanist.drawablepainter(accompanist_ver))
    implementation(Accompanist.flowlayout(accompanist_ver))
    implementation(Accompanist.permissions(accompanist_ver))
    implementation(Accompanist.navigation_animation(accompanist_ver))
    implementation(Accompanist.navigation_material(accompanist_ver))

    // Lifecycle
    implementation(AndroidX.Lifecycle.runtime_ktx(jetpack_lifecycle_ver))
    implementation(AndroidX.Lifecycle.common_java8((jetpack_lifecycle_ver)))
    implementation(AndroidX.Lifecycle.viewmodel_compose_support(jetpack_lifecycle_ver))
    implementation(AndroidX.Lifecycle.livedata_ktx_support(jetpack_lifecycle_ver))

    // Coroutines
    implementation(Kotlin.Coroutines.core(kotlin_coroutines_ver))
    implementation(Kotlin.Coroutines.android(kotlin_coroutines_ver))

    // kotlinx.serialization
    implementation(Kotlin.Serialization.json())

    // 协程封装工具
    implementation(D10NG.DLCoroutinesUtil("0.3"))
    // APP通用工具
    implementation(D10NG.DLAppUtil("2.0"))
    // 字符串字节数据工具
    implementation(D10NG.DLTextUtil("1.3.0"))

    // 拼音处理
    implementation(files("libs/pinyin4j-2.5.0.jar"))
}