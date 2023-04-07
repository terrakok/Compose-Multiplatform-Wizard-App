package io.github.terrakok.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import io.github.skeptick.libres.images.Image
import io.github.terrakok.compose.Res

@Composable
fun ComposeTargetGroup(
    android: MutableState<Boolean>,
    ios: MutableState<Boolean>,
    desktop: MutableState<Boolean>,
    browser: MutableState<Boolean>,
) {
    Row {
        ComposeTargetButton(android, "Android", Res.image.android, true)
        ComposeTargetButton(ios, "iOS", Res.image.apple, null)
        ComposeTargetButton(desktop, "Desktop", Res.image.laptop, null)
        ComposeTargetButton(browser, "Browser", Res.image.language, false)
    }
}

@Composable
private fun ComposeTargetButton(
    state: MutableState<Boolean>,
    name: String,
    icon: Image,
    isFirst: Boolean?
) {
    val shape = when (isFirst) {
        true -> RoundedCornerShape(4.dp, 0.dp, 0.dp, 4.dp)
        false -> RoundedCornerShape(0.dp, 4.dp, 4.dp, 0.dp)
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
            Image(
                modifier = Modifier.width(20.dp),
                painter = painterResource(icon),
                colorFilter = ColorFilter.tint(
                    if (isSelected) MaterialTheme.colors.onPrimary
                    else MaterialTheme.colors.primary
                ),
                contentDescription = null
            )
            Spacer(Modifier.size(10.dp))
            Text(name.uppercase())
        }
    }
}