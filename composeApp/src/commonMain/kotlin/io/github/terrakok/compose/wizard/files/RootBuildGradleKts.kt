package io.github.terrakok.compose.wizard.files

import io.github.terrakok.compose.wizard.ProjectFile
import io.github.terrakok.compose.wizard.ProjectInfo
import io.github.terrakok.compose.wizard.catalogAccessor
import io.github.terrakok.compose.wizard.hasAndroid
import io.github.terrakok.compose.wizard.hasIos
import io.github.terrakok.compose.wizard.isPlugin

class RootBuildGradleKts(info: ProjectInfo) : ProjectFile {
    override val path = "build.gradle.kts"
    override val content = buildString {
        appendLine("plugins {")
        appendLine("    alias(libs.plugins.multiplatform).apply(false)")
        appendLine("    alias(libs.plugins.compose).apply(false)")
        if (info.hasIos) {
            appendLine("    alias(libs.plugins.cocoapods).apply(false)")
        }
        if (info.hasAndroid) {
            appendLine("    alias(libs.plugins.android.application).apply(false)")
        }

        info.dependencies.filter { it.isPlugin() }.forEach { dep ->
            appendLine("    alias(libs.plugins.${dep.catalogAccessor}).apply(false)")
        }

        appendLine("}")
    }
}