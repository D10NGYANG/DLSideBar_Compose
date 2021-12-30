package com.d10ng.sidebar.demo.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class BasicTextFontWeight(style: TextStyle) {
    val Title = BasicTextFontSize(style.copy(color = textTitle))
    val OnSecondary = BasicTextFontSize(style.copy(color = lightOnSecondary))
    val Body = BasicTextFontSize(style.copy(color = textBody))
    val Hint = BasicTextFontSize(style.copy(color = textHint))
    val Error = BasicTextFontSize(style.copy(color = textError))
}

class BasicTextFontSize(style: TextStyle) {
    val v48 = style.copy(fontSize = 48.sp)
    val v46 = style.copy(fontSize = 46.sp)
    val v44 = style.copy(fontSize = 44.sp)
    val v42 = style.copy(fontSize = 42.sp)
    val v40 = style.copy(fontSize = 40.sp)
    val v38 = style.copy(fontSize = 38.sp)
    val v36 = style.copy(fontSize = 36.sp)
    val v34 = style.copy(fontSize = 34.sp)
    val v32 = style.copy(fontSize = 32.sp)
    val v30 = style.copy(fontSize = 30.sp)
    val v28 = style.copy(fontSize = 28.sp)
    val v26 = style.copy(fontSize = 26.sp)
    val v24 = style.copy(fontSize = 24.sp)
    val v22 = style.copy(fontSize = 22.sp)
    val v20 = style.copy(fontSize = 20.sp)
    val v18 = style.copy(fontSize = 18.sp)
    val v16 = style.copy(fontSize = 16.sp)
    val v14 = style.copy(fontSize = 14.sp)
    val v12 = style.copy(fontSize = 12.sp)
    val v10 = style.copy(fontSize = 10.sp)
}

object MyText {
    private val textBasic = TextStyle()
    val Bold = BasicTextFontWeight(textBasic.copy(fontWeight = FontWeight.Bold))
    val Medium = BasicTextFontWeight(textBasic.copy(fontWeight = FontWeight.Medium))
    val Normal = BasicTextFontWeight(textBasic.copy(fontWeight = FontWeight.Normal))
}