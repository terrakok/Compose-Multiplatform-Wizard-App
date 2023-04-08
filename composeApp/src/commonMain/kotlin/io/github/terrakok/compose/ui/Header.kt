package io.github.terrakok.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.Box

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(100.dp),
            imageVector = TablerIcons.Box,
            contentDescription = null
        )
        Spacer(Modifier.size(20.dp))
        Text(
            text = "Compose Multiplatform Wizard",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}