package io.github.terrakok.compose.wizard.files.app

import io.github.terrakok.compose.wizard.ProjectFile

class GraphQLSchema : ProjectFile {
    override val path = "composeApp/src/commonMain/graphql/schema.graphqls"
    override val content = """
        type Query {
          hello: String!
        }
    """.trimIndent()
}
