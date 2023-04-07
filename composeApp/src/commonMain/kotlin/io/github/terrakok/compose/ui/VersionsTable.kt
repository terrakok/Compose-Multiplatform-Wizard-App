package io.github.terrakok.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.terrakok.compose.wizard.ProjectInfo

@Composable
fun VersionsTable(info: ProjectInfo) {
    val isShowVersions by LocalShowVersions.current
    if (isShowVersions)
        Card(
            modifier = Modifier.width(480.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(modifier = Modifier.weight(1f), text = "Kotlin")
                    Text(modifier = Modifier.weight(1f), text = info.kotlinVersion)
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(modifier = Modifier.weight(1f), text = "Compose")
                    Text(modifier = Modifier.weight(1f), text = info.composeVersion)
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(modifier = Modifier.weight(1f), text = "Gradle")
                    Text(modifier = Modifier.weight(1f), text = info.gradleVersion)
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(modifier = Modifier.weight(1f), text = "Android Gradle Plugin")
                    Text(modifier = Modifier.weight(1f), text = info.agpVersion)
                }
            }
        }
    Spacer(Modifier.size(20.dp))
}