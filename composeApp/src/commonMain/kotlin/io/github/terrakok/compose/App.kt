package io.github.terrakok.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import io.github.terrakok.compose.wizard.ProjectInfo

@Composable
fun App() = AppTheme {
    val vScroll = rememberScrollState()
    val hScroll = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(vScroll)
            .horizontalScroll(hScroll)
    ) {
        Card(
            modifier = Modifier
                .padding(40.dp)
                .align(Alignment.Center)
                .requiredHeightIn(min = 500.dp)
                .requiredWidthIn(min = 900.dp)
        ) {
            TopMenu()
            Column(
                modifier = Modifier.padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header()
                Spacer(Modifier.size(20.dp))

                val default = ProjectInfo()
                var projectNameState by remember { mutableStateOf(default.name) }
                var projectIdState by remember { mutableStateOf(default.packageId) }

                OutlinedTextField(
                    modifier = Modifier.requiredWidthIn(min = 480.dp),
                    value = projectNameState,
                    onValueChange = { projectNameState = it },
                    label = { Text("Project name") }
                )
                Spacer(Modifier.size(20.dp))

                OutlinedTextField(
                    modifier = Modifier.requiredWidthIn(min = 480.dp),
                    value = projectIdState,
                    onValueChange = { projectIdState = it },
                    label = { Text("Project ID") }
                )
                Spacer(Modifier.size(20.dp))

                val isAndroid = remember { mutableStateOf(true) }
                val isIos = remember { mutableStateOf(true) }
                val isDesktop = remember { mutableStateOf(true) }
                val isBrowser = remember { mutableStateOf(true) }
                ComposeTargetGroup(isAndroid, isIos, isDesktop, isBrowser)
                Spacer(Modifier.size(20.dp))

                Button(onClick = {}) {
                    Image(
                        painter = painterResource(Res.image.arrow_circle_down),
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                        contentDescription = null
                    )
                    Spacer(Modifier.size(10.dp))
                    Text("Download")
                }
            }
        }
    }
}

internal expect fun openUrl(url: String?)