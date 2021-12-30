package com.d10ng.sidebar.demo.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.d10ng.sidebar.demo.bean.AreaBean
import com.d10ng.sidebar.demo.model.AppViewModel
import com.google.accompanist.insets.statusBarsPadding

const val HOME_SCREEN = "home_screen"

@Composable
fun HomeScreen(
    navController: NavHostController,
    app: AppViewModel
) {

    val selectBean by app.selectAreaLive.observeAsState(AreaBean())

    Column(
        modifier = Modifier.statusBarsPadding().padding(16.dp)
    ) {
        Button(onClick = {
            navController.navigate(AREA_SCREEN)
        }) {
            Text(text = "跳到微信国家或地区代码")
        }
        if (selectBean.zh.isNotEmpty()) {
            Text(text = "${selectBean.zh} (+${selectBean.code})")
        }
    }
}