package io.github.terrakok.compose.wizard

import io.github.terrakok.compose.wizard.files.Gitignore
import io.github.terrakok.compose.wizard.files.GradleBat
import io.github.terrakok.compose.wizard.files.GradleLibsVersion
import io.github.terrakok.compose.wizard.files.GradleProperties
import io.github.terrakok.compose.wizard.files.GradleWrapperJar
import io.github.terrakok.compose.wizard.files.GradleWrapperProperties
import io.github.terrakok.compose.wizard.files.Gradlew
import io.github.terrakok.compose.wizard.files.Readme
import io.github.terrakok.compose.wizard.files.RootBuildGradleKts
import io.github.terrakok.compose.wizard.files.SettingsGradleKts
import io.github.terrakok.compose.wizard.files.app.AndroidAppKt
import io.github.terrakok.compose.wizard.files.app.AndroidManifest
import io.github.terrakok.compose.wizard.files.app.AppKt
import io.github.terrakok.compose.wizard.files.app.BrowserAppKt
import io.github.terrakok.compose.wizard.files.app.BrowserMainKt
import io.github.terrakok.compose.wizard.files.app.BrowserViewportWindowKt
import io.github.terrakok.compose.wizard.files.app.ColorKt
import io.github.terrakok.compose.wizard.files.app.DesktopAppKt
import io.github.terrakok.compose.wizard.files.app.DesktopMainKt
import io.github.terrakok.compose.wizard.files.app.GraphQLQuery
import io.github.terrakok.compose.wizard.files.app.GraphQLSchema
import io.github.terrakok.compose.wizard.files.app.IndexHtml
import io.github.terrakok.compose.wizard.files.app.IosAccentColor
import io.github.terrakok.compose.wizard.files.app.IosAppIcon
import io.github.terrakok.compose.wizard.files.app.IosAppKt
import io.github.terrakok.compose.wizard.files.app.IosAppSwift
import io.github.terrakok.compose.wizard.files.app.IosAssets
import io.github.terrakok.compose.wizard.files.app.IosMainKt
import io.github.terrakok.compose.wizard.files.app.IosPbxproj
import io.github.terrakok.compose.wizard.files.app.IosPreviewAssets
import io.github.terrakok.compose.wizard.files.app.IosXcworkspace
import io.github.terrakok.compose.wizard.files.app.ModuleBuildGradleKts
import io.github.terrakok.compose.wizard.files.app.Podfile
import io.github.terrakok.compose.wizard.files.app.Podspec
import io.github.terrakok.compose.wizard.files.app.ThemeKt

fun ProjectInfo.buildFiles() = buildList {
    add(Gitignore())
    add(Readme(this@buildFiles))

    add(GradleBat())
    add(Gradlew())
    add(GradleWrapperProperties(this@buildFiles))
    add(GradleWrapperJar())
    add(GradleLibsVersion(this@buildFiles))

    add(GradleProperties())
    add(RootBuildGradleKts(this@buildFiles))
    add(SettingsGradleKts(this@buildFiles))

    add(ModuleBuildGradleKts(this@buildFiles))
    add(ColorKt(this@buildFiles))
    add(ThemeKt(this@buildFiles))
    add(AppKt(this@buildFiles))

    if (this@buildFiles.dependencies.contains(ApolloPlugin)) {
        add(GraphQLSchema())
        add(GraphQLQuery())
    }

    if (this@buildFiles.hasAndroid) {
        add(AndroidManifest(this@buildFiles))
        add(AndroidAppKt(this@buildFiles))
    }

    if (this@buildFiles.hasDesktop) {
        add(DesktopAppKt(this@buildFiles))
        add(DesktopMainKt(this@buildFiles))
    }

    if (this@buildFiles.hasIos) {
        add(Podspec(this@buildFiles))
        add(IosAppKt(this@buildFiles))
        add(IosMainKt(this@buildFiles))

        add(Podfile())
        add(IosAppIcon())
        add(IosAccentColor())
        add(IosAssets())
        add(IosPreviewAssets())
        add(IosAppSwift())
        add(IosXcworkspace())
        add(IosPbxproj(this@buildFiles))
    }

    if (this@buildFiles.hasBrowser) {
        add(BrowserAppKt(this@buildFiles))
        add(IndexHtml(this@buildFiles))
        add(BrowserMainKt(this@buildFiles))
        add(BrowserViewportWindowKt())
    }
}