# DLSideBar

> ----------
> ⚠️ 本项目已停止维护，相关组件已迁移至 [D10NGYANG/DLJetpackComposeUtil](https://github.com/D10NGYANG/DLJetpackComposeUtil)，以`IndexBar`组件的形式呈现。
> 
> ----------

简单易用的SideBar 快速定位侧边栏A~Z 仿微信国家或地区代码选择 `jetpack compose`版本
[![](https://jitpack.io/v/D10NGYANG/DLSideBar_Compose.svg)](https://jitpack.io/#D10NGYANG/DLSideBar_Compose)

普通Android XML布局版本[在这里](https://github.com/D10NGYANG/DL10SideBar)

# 截图
<img src="https://github.com/D10NGYANG/DLSideBar_Compose/blob/master/image/image1.png" width="200"/>
<img src="https://github.com/D10NGYANG/DLSideBar_Compose/blob/master/image/image2.png" width="200"/><br/>

# 使用说明
1 添加仓库
```groovy
allprojects {
    repositories {
        maven { url 'https://raw.githubusercontent.com/D10NGYANG/maven-repo/main/repository'}
    }
}
```
2 添加仓库
```groovy
dependencies {
    implementation 'com.github.D10NGYANG:DLSideBar_Compose:1.2.5'

    // Compose
    def composeBom = platform('androidx.compose:compose-bom:2023.08.00')
    implementation composeBom
    androidTestImplementation composeBom
    // Material Design 2
    implementation 'androidx.compose.material:material'
    // Android Studio Preview support
    implementation 'androidx.compose.ui:ui-tooling-preview'
    debugImplementation 'androidx.compose.ui:ui-tooling'
}
```
3 在你的UI页面中使用
```kotlin
val scope = rememberCoroutineScope()
SideBar(
    onSelect = { value ->
        // 选中字符，如"A"
        val index = dataList.indexOfFirst { it.py[0].uppercase() == value }
        if (index >= 0) {
            scope.launch { listState.scrollToItem(index) }
        }
    }
) {
    // 列表
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = listState
    ) {
        itemsIndexed(dataList) { index, item ->
            // todo 单项UI
        }
    }
}
```
4 更多参数说明

```kotlin
@ExperimentalComposeUiApi
@Composable
fun SideBar(
    // 列表中显示的字符列表
    chars: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#",
    // 选中字符后返回该字符
    onSelect: (String) -> Unit,
    // 触摸列表时，列表的颜色，不触摸列表时，颜色透明
    touchColor: Color = Color(0xFFEBEEF0),
    // 列表中字符的样式
    charText: @Composable (String) -> Unit = {
        DefaultSideBarCharText(text = it)
    },
    // 选中字符弹出的样式
    selectText: @Composable BoxScope.(String) -> Unit ={
        DefaultSideBarSelectText(text = it)
    },
    // 列表内容
    content: @Composable BoxScope.() -> Unit
)
```
5 混淆
```properties
-keep class com.d10ng.sidebar.** {*;}
-dontwarn com.d10ng.sidebar.**
```
