package io.github.terrakok.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopMenu(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(10.dp),
        horizontalArrangement = Arrangement.End
    ) {
        var isShowVersions by LocalShowVersions.current
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { isShowVersions = !isShowVersions }
                .padding(8.dp),
            painter = painterResource(
                if (isShowVersions) "code.xml" else "code_off.xml"
            ),
            colorFilter = ColorFilter.tint(getContentColor()),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { openUrl("https://developer.android.com/jetpack/compose/documentation") }
                .padding(8.dp),
            painter = painterResource("menu_book.xml"),
            colorFilter = ColorFilter.tint(getContentColor()),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { openUrl("https://github.com/terrakok/Compose-Multiplatform-Wizard") }
                .padding(8.dp),
            painter = painterResource("github.xml"),
            colorFilter = ColorFilter.tint(getContentColor()),
            contentDescription = null
        )
        var isDark by LocalThemeIsDark.current
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { isDark = !isDark }
                .padding(8.dp),
            painter = painterResource(
                if (isDark) "light_mode.xml" else "dark_mode.xml"
            ),
            colorFilter = ColorFilter.tint(getContentColor()),
            contentDescription = null
        )
    }
}