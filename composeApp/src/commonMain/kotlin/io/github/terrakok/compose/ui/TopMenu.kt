package io.github.terrakok.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.BrandGithub
import compose.icons.tablericons.Eye
import compose.icons.tablericons.EyeOff
import compose.icons.tablericons.FileText
import compose.icons.tablericons.Moon
import compose.icons.tablericons.Sun

@Composable
fun TopMenu(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(10.dp),
        horizontalArrangement = Arrangement.End
    ) {
        var isShowVersions by LocalShowVersions.current
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { isShowVersions = !isShowVersions }
                .padding(8.dp),
            imageVector = if (isShowVersions) TablerIcons.Eye else TablerIcons.EyeOff,
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { openUrl("https://developer.android.com/jetpack/compose/documentation") }
                .padding(8.dp),
            imageVector = TablerIcons.FileText,
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { openUrl("https://github.com/terrakok/Compose-Multiplatform-Wizard") }
                .padding(8.dp),
            imageVector = TablerIcons.BrandGithub,
            contentDescription = null
        )
        var isDark by LocalThemeIsDark.current
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { isDark = !isDark }
                .padding(8.dp),
            imageVector = if (isDark) TablerIcons.Sun else TablerIcons.Moon,
            contentDescription = null
        )
    }
}