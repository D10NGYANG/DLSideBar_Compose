package com.d10ng.sidebar.lib

import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@ExperimentalComposeUiApi
@Composable
fun SideBar(
    chars: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#",
    onSelect: (String) -> Unit,
    touchColor: Color = Color(0xFFEBEEF0),
    charText: @Composable (String) -> Unit = {
        DefaultSideBarCharText(text = it)
    },
    selectText: @Composable BoxScope.(String) -> Unit ={
        DefaultSideBarSelectText(text = it)
    },
    content: @Composable BoxScope.() -> Unit
) {
    val charArray = remember(chars) { chars.toCharArray() }
    var isTouch by remember {
        mutableStateOf(false)
    }
    var selectChar by remember {
        mutableStateOf("")
    }
    var barSize by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        content()

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .background(if (isTouch) touchColor else Color.Transparent)
                .padding(vertical = 16.dp)
                .align(Alignment.CenterEnd)
                .onSizeChanged {
                    barSize = it.height
                }
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                            isTouch = false
                            selectChar = ""
                        }
                        else -> {
                            isTouch = true
                            if (barSize != 0) {
                                val pos = it.y / barSize * charArray.size
                                selectChar = charArray[pos
                                    .roundToInt()
                                    .coerceAtLeast(0)
                                    .coerceAtMost(charArray.size - 1)].toString()
                                onSelect.invoke(selectChar)
                            }
                        }
                    }
                    true
                },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            charArray.forEach { char ->
                charText(char.toString())
            }
        }

        if (selectChar.isNotEmpty()) {
            selectText(selectChar)
        }
    }
}

@Composable
fun DefaultSideBarCharText(
    text: String
) {
    Text(
        text = text,
        style = TextStyle(fontWeight = FontWeight.Normal, color = Color(0xFF999999), fontSize = 12.sp),
        modifier = Modifier
            .width(24.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun BoxScope.DefaultSideBarSelectText(
    text: String
) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .align(Alignment.Center)
            .background(Color(0x77999999), RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = TextStyle(fontWeight = FontWeight.Bold, color = Color(0xFFFFFFFF), fontSize = 38.sp))
    }
}