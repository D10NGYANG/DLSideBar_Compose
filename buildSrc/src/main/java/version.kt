object Maven {
    const val public = "maven-publish"
    const val jitpack = "https://jitpack.io"
    object Publish {
        const val release = "release"
        const val componentJava = "java"
    }
}

object Android {
    const val classpath_gradle = "com.android.tools.build:gradle:7.0.4"
    const val plugins_application = "com.android.application"
    const val plugins_library = "com.android.library"
    const val compile_sdk = 31
    const val min_sdk = 22
    const val target_sdk = 30
    const val androidx_core = "androidx.core:core-ktx:1.6.0"
    const val androidx_appcompat = "androidx.appcompat:appcompat:1.3.1"
    const val google_material = "com.google.android.material:material:1.4.0"
    const val datastore_preferences = "androidx.datastore:datastore-preferences:1.0.0"
}

object Test {
    const val junit = "junit:junit:4.12"
}

object Kotlin {
    const val version = "1.5.31"
    const val classpath_gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    const val classpath_serialization = "org.jetbrains.kotlin:kotlin-serialization:$version"
    const val plugins_android = "kotlin-android"
    const val plugins_kapt = "kotlin-kapt"
    const val plugins_parcelize = "kotlin-parcelize"
    const val plugins_serialization = "kotlinx-serialization"
    const val jvm_target = "1.8"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    const val coroutines_version = "1.5.2"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
    const val serialization_json = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
    const val ktor_version = "1.6.6"
    const val ktor_core = "io.ktor:ktor-client-core:$ktor_version"
    const val ktor_cio = "io.ktor:ktor-client-cio:$ktor_version"
    const val ktor_apache = "io.ktor:ktor-client-apache:$ktor_version"
    const val ktor_java = "io.ktor:ktor-client-java:$ktor_version"
    const val ktor_jetty = "io.ktor:ktor-client-jetty:$ktor_version"
    const val ktor_android = "io.ktor:ktor-client-android:$ktor_version"
    const val ktor_okhttp = "io.ktor:ktor-client-okhttp:$ktor_version"
    const val ktor_js = "io.ktor:ktor-client-js:$ktor_version"
    const val ktor_ios = "io.ktor:ktor-client-ios:$ktor_version"
    const val ktor_curl = "io.ktor:ktor-client-curl:$ktor_version"
    const val ktor_logging = "io.ktor:ktor-client-logging:$ktor_version"
    const val ktor_logback = "ch.qos.logback:logback-classic:1.2.7"
    const val ktor_serialization = "io.ktor:ktor-client-serialization:$ktor_version"
}

object Compose {
    const val version = "1.0.5"
    const val androidx_ui = "androidx.compose.ui:ui:$version"
    const val androidx_ui_test = "androidx.compose.ui:ui-test-junit4:$version"
    const val androidx_tooling = "androidx.compose.ui:ui-tooling:$version"
    const val androidx_foundation = "androidx.compose.foundation:foundation:$version"
    const val androidx_material = "androidx.compose.material:material:$version"
    const val androidx_material_icons_core = "androidx.compose.material:material-icons-core:$version"
    const val androidx_material_icons_extended = "androidx.compose.material:material-icons-extended:$version"
    const val androidx_navigation = "androidx.navigation:navigation-compose:2.4.0-alpha07"
    const val activity = "androidx.activity:activity-compose:1.3.1"
    const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
}

object Accompanist {
    const val version = "0.18.0"
    const val insets = "com.google.accompanist:accompanist-insets:$version"
    const val insets_ui = "com.google.accompanist:accompanist-insets-ui:$version"
    const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:$version"
    const val swiperefresh = "com.google.accompanist:accompanist-swiperefresh:$version"
    const val navigation_animation = "com.google.accompanist:accompanist-navigation-animation:$version"
}

object Paging {
    const val version = "3.0.1"
    const val runtime = "androidx.paging:paging-runtime:$version"
    const val test = "androidx.paging:paging-common:$version"
    const val compose_support = "androidx.paging:paging-compose:1.0.0-alpha14"
}

object Room {
    const val version = "2.3.0"
    const val runtime = "androidx.room:room-runtime:$version"
    const val compiler = "androidx.room:room-compiler:$version"
    const val ktx_support = "androidx.room:room-ktx:$version"
}

object Lifecycle {
    const val version = "2.4.0"
    const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    const val compiler = "androidx.lifecycle:lifecycle-common-java8:$version"
    const val viewmodel_support = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    const val compose_viewmodel_support = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
    const val savedstate_viewmodel_support = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
    const val livedata_support = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    const val service_support = "androidx.lifecycle:lifecycle-service:$version"
    const val process_support = "androidx.lifecycle:lifecycle-process:$version"
    const val test = "androidx.arch.core:core-testing:2.1.0"
}

object Tencent {
    object Bugly {
        const val classpath = "com.tencent.bugly:crashreport:latest.release"
        const val crashreport = "com.tencent.bugly:crashreport:latest.release"
        const val nativecrashreport = "com.tencent.bugly:nativecrashreport:latest.release"
    }
    const val mmkv = "com.tencent:mmkv:1.2.11"
}

object D10NG {
    const val appUtil = "com.github.D10NGYANG:DLAppUtil:1.7"
    const val coroutinesUtil = "com.github.D10NGYANG:DLCoroutinesUtil:0.2"
    const val dateUtil = "com.github.D10NGYANG:DLDateUtil:1.3"
    const val stringUtil = "com.github.D10NGYANG:DLStringUtil:1.12"
    const val textUtil = "com.github.D10NGYANG:DLTextUtil:1.2.3"
    const val gpsUtil = "com.github.D10NGYANG:DLGpsUtil:1.6"
    const val latlngUtil = "com.github.D10NGYANG:DLLatLngUtil:1.2"
    const val retrofitCoroutines = "com.github.D10NGYANG:DL10RetrofitCoroutines:1.4"
    const val moshiUtil = "com.github.D10NGYANG:DLMoshiUtil:1.2"
}