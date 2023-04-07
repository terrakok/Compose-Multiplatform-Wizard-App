package io.github.terrakok.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import io.github.terrakok.compose.wizard.Dependency
import org.jetbrains.compose.resources.painterResource

@Composable
fun DependencyCard(
    modifier: Modifier = Modifier,
    dependency: Dependency,
    selected: MutableState<Boolean>
) {
    var isSelected by selected
    Card(
        modifier = modifier.padding(8.dp).fillMaxWidth().height(150.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize().clickable { isSelected = !isSelected }
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(end = 40.dp),
                    style = MaterialTheme.typography.h6,
                    text = dependency.title
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.body2,
                    text = dependency.description
                )
            }
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .size(24.dp)
                    .align(Alignment.TopEnd),
                painter = painterResource(
                    if (isSelected) "circle_checked.xml" else "circle_unchecked.xml"
                ),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                contentDescription = null
            )
            TextButton(
                modifier = Modifier.align(Alignment.BottomEnd).padding(end = 8.dp),
                onClick = { openUrl(dependency.url) }
            ) {
                Text("MORE INFO")
            }
        }
    }
}