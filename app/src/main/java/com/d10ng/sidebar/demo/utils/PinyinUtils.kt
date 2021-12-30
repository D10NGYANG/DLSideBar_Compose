package com.d10ng.sidebar.demo.utils

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination

/**
 * 将字符串中的中文转化为拼音,其他字符不变
 * @receiver String
 * @return String
 */
fun String.getPinYin(): String {
    val format = HanyuPinyinOutputFormat().apply {
        caseType = HanyuPinyinCaseType.LOWERCASE
        toneType = HanyuPinyinToneType.WITHOUT_TONE
        vCharType = HanyuPinyinVCharType.WITH_V
    }
    val input = this.trim { it <= ' ' }.toCharArray()
    var outPut = ""
    try {
        for (char in input) {
            outPut += if (char.toString().matches("[\\u4E00-\\u9FA5]+".toRegex())) {
                PinyinHelper.toHanyuPinyinStringArray(char, format)[0]
            } else {
                char.toString()
            }
        }
    } catch (e: BadHanyuPinyinOutputFormatCombination) {
        e.printStackTrace()
    }
    return outPut
}

/**
 * 汉字转换为汉语拼音首字母，英文字符不变
 * @receiver String
 * @return String
 */
fun String.getFirstPY(): String {
    val pybf = StringBuffer()
    val arr = this.toCharArray()
    val defaultFormat = HanyuPinyinOutputFormat().apply {
        caseType = HanyuPinyinCaseType.LOWERCASE
        toneType = HanyuPinyinToneType.WITHOUT_TONE
    }
    for (char in arr) {
        if (char.code > 128) {
            try {
                val temp = PinyinHelper.toHanyuPinyinStringArray(char, defaultFormat)
                if (temp != null) {
                    pybf.append(temp[0][0])
                }
            } catch (e: BadHanyuPinyinOutputFormatCombination) {
                e.printStackTrace()
            }
        } else {
            pybf.append(char)
        }
    }
    return pybf.toString().replace("\\W".toRegex(), "").trim { it <= ' ' }
}