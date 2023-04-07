package io.github.terrakok.compose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import kotlin.math.roundToInt

@Composable
fun SimpleGrid(
    modifier: Modifier = Modifier,
    columnWidth: Dp,
    itemCount: Int,
    content: @Composable (Int) -> Unit
) {
    BoxWithConstraints(modifier = modifier) {
        val box = this
        val columns = (box.maxWidth / columnWidth).roundToInt()

        Column(modifier = modifier) {
            repeat(itemCount / columns) { row ->
                val delta = row * columns
                Row {
                    repeat(columns) { column ->
                        Box(modifier = Modifier.weight(1f)) {
                            val index = delta + column
                            if (index < itemCount) {
                                content(index)
                            }
                        }
                    }
                }
            }
        }
    }
}
