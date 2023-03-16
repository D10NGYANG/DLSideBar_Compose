package com.d10ng.sidebar.demo.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.d10ng.sidebar.demo.model.AreaModel
import com.d10ng.sidebar.demo.ui.page.destinations.AreaScreenDestination
import com.d10ng.sidebar.demo.ui.theme.PageTransitions
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalComposeUiApi::class)
@RootNavGraph(start = true)
@Destination(style = PageTransitions::class)
@Composable
fun HomeScreen(
    nav: DestinationsNavigator
) {

    val selectBean by AreaModel.selectAreaFlow.collectAsState()

    Column(
        modifier = Modifier.statusBarsPadding().padding(16.dp)
    ) {
        Button(onClick = {
            nav.navigate(AreaScreenDestination)
        }) {
            Text(text = "跳到微信国家或地区代码")
        }
        if (selectBean.zh.isNotEmpty()) {
            Text(text = "${selectBean.zh} (+${selectBean.code})")
        }
    }
}