package io.github.terrakok.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.BrandAndroid
import compose.icons.tablericons.BrandApple
import compose.icons.tablericons.DeviceLaptop
import compose.icons.tablericons.Planet

@Composable
fun ComposeTargetGroup(
    android: MutableState<Boolean>,
    ios: MutableState<Boolean>,
    desktop: MutableState<Boolean>,
    browser: MutableState<Boolean>,
) {
    Row {
        ComposeTargetButton(android, "Android", TablerIcons.BrandAndroid, true)
        ComposeTargetButton(ios, "iOS", TablerIcons.BrandApple, null)
        ComposeTargetButton(desktop, "Desktop", TablerIcons.DeviceLaptop, null)
        ComposeTargetButton(browser, "Browser", TablerIcons.Planet, false)
    }
}

@Composable
private fun ComposeTargetButton(
    state: MutableState<Boolean>,
    name: String,
    icon: ImageVector,
    isFirst: Boolean?
) {
    val shape = when (isFirst) {
        //TODO: fix JS compilation
//        true -> RoundedCornerShape(4.dp, 0.dp, 0.dp, 4.dp)
//        false -> RoundedCornerShape(0.dp, 4.dp, 4.dp, 0.dp)
        else -> RoundedCornerShape(0.dp)
    }

    var isSelected by state

    Button(
        modifier = Modifier.width(120.dp).height(80.dp).shadow(0.dp),
        shape = shape,
        border = if (isSelected) null else ButtonDefaults.outlinedBorder,
        colors = if (isSelected) ButtonDefaults.buttonColors() else ButtonDefaults.outlinedButtonColors(),
        onClick = { isSelected = !isSelected }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.width(20.dp),
                imageVector = icon,
                tint = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary,
                contentDescription = null
            )
            Spacer(Modifier.size(10.dp))
            Text(name.uppercase())
        }
    }
}