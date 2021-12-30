package com.d10ng.sidebar.demo.bean

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class AreaBean(
    @SerialName("code")
    var code: Int = 0,
    @SerialName("en")
    var en: String = "",
    @SerialName("locale")
    var locale: String = "",
    @SerialName("tw")
    var tw: String = "",
    @SerialName("zh")
    var zh: String = "",

    // 拼音
    var py: String = ""
)
