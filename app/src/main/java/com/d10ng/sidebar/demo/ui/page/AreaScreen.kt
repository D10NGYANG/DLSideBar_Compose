package com.d10ng.sidebar.demo.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.d10ng.sidebar.demo.R
import com.d10ng.sidebar.demo.bean.AreaBean
import com.d10ng.sidebar.demo.model.AppViewModel
import com.d10ng.sidebar.demo.ui.theme.*
import com.d10ng.sidebar.demo.ui.view.Input
import com.d10ng.sidebar.lib.SideBar
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsHeight
import kotlinx.coroutines.launch

const val AREA_SCREEN = "area_screen"

@ExperimentalComposeUiApi
@Composable
fun AreaScreen(
    navController: NavHostController,
    app: AppViewModel
) {

    var isShowSearch by remember {
        mutableStateOf(false)
    }
    var inputValue by remember {
        mutableStateOf("")
    }

    val dataList = remember(isShowSearch, inputValue) {
        if (isShowSearch) {
            app.areas.filter {
                it.zh.contains(inputValue) ||
                        "+${it.code}".contains(inputValue) ||
                        it.py.contains(inputValue, true) ||
                        it.en.contains(inputValue, true) ||
                        it.locale.contains(inputValue, true)
            }
        } else {
            app.areas
        }
    }

    val listState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBackground)
            .navigationBarsPadding()
    ) {
        // 状态栏
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .statusBarsHeight()
        )

        // 标题栏+搜索栏
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_32),
                contentDescription = "返回",
                tint = lightSecondary,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        if (isShowSearch) isShowSearch = false else navController.navigateUp()
                    }
            )

            if (isShowSearch) {
                Input(
                    value = inputValue,
                    onValueChange = {
                        inputValue = it
                    },
                    textStyle = MyText.Normal.Title.v18,
                    placeholder = "请输入",
                    placeholderStyle = MyText.Normal.Hint.v18,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )
            } else {
                Text(
                    text = "选择国家或地区代码",
                    style = MyText.Bold.Title.v18,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_32),
                    contentDescription = "查询",
                    tint = textTitle,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable {
                            isShowSearch = true
                        }
                )
            }
        }

        val scope = rememberCoroutineScope()
        SideBar(
            onSelect = { value ->
                val index = dataList.indexOfFirst { it.py[0].uppercase() == value }
                if (index >= 0) {
                    scope.launch { listState.scrollToItem(index) }
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = listState
            ) {
                itemsIndexed(dataList) { index, item ->
                    val isShowTag = if (index == 0) {
                        true
                    } else {
                        val last = dataList[index - 1]
                        last.py[0].uppercase() != item.py[0].uppercase()
                    }
                    AreaItemView(info = item, isShowTag = isShowTag) {
                        app.selectAreaLive.value = item
                        navController.navigateUp()
                    }
                }
            }
        }
    }
}

@Composable
private fun AreaItemView(
    info: AreaBean,
    isShowTag: Boolean,
    onClick: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick.invoke() }
            .padding(horizontal = 16.dp)
    ) {
        if (isShowTag) {
            Text(
                text = info.py[0].toString().uppercase(),
                style = MyText.Normal.Hint.v16,
                modifier = Modifier.padding(top = 24.dp, bottom = 4.dp)
            )
            Divider()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = info.zh,
                style = MyText.Normal.Body.v16
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(end = 36.dp)
                    .background(colorLine, RoundedCornerShape(4.dp))
                    .padding(6.dp)
            ) {
                Text(
                    text = info.code.toString(),
                    style = MyText.Normal.Hint.v12
                )
            }
        }
    }
}

@Preview
@Composable
fun AreaItemView_Test() {
    Column(modifier = Modifier.background(Color.White)) {
        AreaItemView(AreaBean(86, "China", "CN", "中國", "中国", "zhongguo"), true) {}
    }
}