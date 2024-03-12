plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    signingConfigs {
        create("my_config") {
            storeFile = file("C:\\Users\\ngaio\\test_keystore.jks")
            storePassword = "170503"
            keyAlias = "Sinh1705"
            keyPassword = "170503"
        }
    }
    namespace = "com.example.demo_firebase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.demo_firebase"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("my_config")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation(platform("com.google.firebase:firebase-bom:32.7.1"))
    implementation("com.google.firebase:firebase-analytics")
    //push notification
    implementation("com.google.firebase:firebase-messaging")
    //login
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.firebaseui:firebase-ui-database:8.0.2")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    //lưu ý add thư viện này vào
    //implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.android.exoplayer:exoplayer:2.19.1")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.google.android.exoplayer:exoplayer-core:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-dash:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-hls:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-rtsp:2.19.1")
    // Thay phiên bản mới nhất
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

}