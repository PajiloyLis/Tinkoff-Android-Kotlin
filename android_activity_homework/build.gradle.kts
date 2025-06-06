// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.pluginSerialization)
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
//    alias(libs.plugins.ksp) apply false
//    alias(libs.plugins.hilt)
    alias(libs.plugins.kapt) apply false

//    alias(libs.plugins.navigation.safeargs) apply false
}
true // Needed to make the Suppress annotation work for the plugins block
