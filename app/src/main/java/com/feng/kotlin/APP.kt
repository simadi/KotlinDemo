package com.feng.kotlin

import android.app.Application

/**
 * description：定义全局的Application
 * 作者：ldm
 * 时间：20162016/8/6 16:44
 * 邮箱：1786911211@qq.com
 */
class APP : Application() {
    companion object {
        //定义Application对象
        private  var instance: Application? = null;

        //获取Application对象的方法
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        //实例化对象
        instance = this
    }
    //最后：不要忘记在AndroidManfest.xml中注册该APP
}