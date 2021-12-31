package com.d10ng.sidebar.demo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d10ng.applib.resource.getAssetsJSONArray
import com.d10ng.sidebar.demo.app.MyApp
import com.d10ng.sidebar.demo.bean.AreaBean
import com.d10ng.text.string.toPinYin
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/** 自定义规则的JSON工具 */
val json by lazy {
    Json {
        // 忽略JSON字符串里有但data class中没有的key
        ignoreUnknownKeys = true
        // 如果接收到的JSON字符串的value为null，但是data class中的对应属性不能为null，那就使用属性的默认值
        coerceInputValues = true
        // 如果创建data class实例时有些属性没有赋值，那就使用默认值进行转换成JSON字符串
        encodeDefaults = true
    }
}

class AppViewModel: ViewModel() {

    /** 国家或地区列表 */
    val areas: List<AreaBean>

    init {
        val jsonObj = MyApp.instance().getAssetsJSONArray("area_phone_code.json").toString()
        val list: MutableList<AreaBean> = json.decodeFromString(jsonObj)
        list.forEach { item -> item.py = item.zh.toPinYin() }
        areas = list.sortedBy { it.py }
    }

    /** 选中地区 */
    val selectAreaLive = MutableLiveData(AreaBean())
}