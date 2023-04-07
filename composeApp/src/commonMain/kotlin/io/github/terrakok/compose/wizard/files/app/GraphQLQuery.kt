package io.github.terrakok.compose.wizard.files.app

import io.github.terrakok.compose.wizard.ProjectFile

class GraphQLQuery : ProjectFile {
    override val path = "composeApp/src/commonMain/graphql/HelloQuery.graphql"
    override val content = """
        query HelloQuery {
          hello
        }
    """.trimIndent()
}
