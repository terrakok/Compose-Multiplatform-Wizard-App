package io.github.terrakok.compose.wizard.files

import io.github.terrakok.compose.wizard.ProjectFile

class Gitignore : ProjectFile {
    override val path = ".gitignore"
    override val content = """
*.iml
.gradle
.idea
.DS_Store
build
*/build
captures
.externalNativeBuild
.cxx
local.properties
xcuserdata/
Pods/
*.jks
*yarn.lock
"""
}