/* build.gradle.kts (根项目)
* 1、 配置全局插件，在根项目中声明插件，在子模块中应用。
* 2、 使用 Kotlin DSL 编写 Gradle 构建脚本。
* 3、 适用于多模块项目，所有子模块共享配置。
* 4、 统一版本控制。不会自动生效。
* */
// settings.gradle.kts

// build.gradle.kts (根项目)
//plugins {
//    // 声明但不应用插件
//    alias(libs.plugins.kotlin.android) apply false
//    alias(libs.plugins.kotlin.compose) apply false
//    alias(libs.plugins.kotlin.kapt) apply false
//}


// 所有子模块共享的配置
allprojects {
    group = "com.example"
    version = "1.0.0"

    // 全局依赖配置
    configurations.all {
        resolutionStrategy {
            // todo 强制所有模块使用相同版本的依赖
        }
    }
}

//// 全局 Spotless 配置（代码格式化）
//spotless {
//    kotlin {
//        ktlint("0.50.0")
//    }
//}