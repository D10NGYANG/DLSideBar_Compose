package com.d10ng.sidebar.demo.app

import android.app.Application

class MyApp: Application() {

    companion object{
        private lateinit var mInstance: MyApp
        /** 获取实例 */
        fun instance() : MyApp = mInstance
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }
}