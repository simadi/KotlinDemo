package com.feng.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.feng.kotlin.R
import com.feng.kotlin.adapter.FirstKotlinAdapter

import kotlinx.android.synthetic.main.activity_recyle.*
/**
 * Kotlin中使用RecycleView
 *
 * @author ldm
 * @description：
 * @date 2016-8-4 下午16:54:29
 */
class RecycleViewAct : AppCompatActivity() {

    //实现onCreate(）方法，关键字“fun”
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyle)

        recycle_view.layoutManager = LinearLayoutManager(this);
        //初始化Adapter并设置数据
        recycle_view.adapter = FirstKotlinAdapter(listOf("Kotlin DEMO数据1","Kotlin DEMO数据21/8", "Kotlin DEMO数据17","Kotlin DEMO数据111", "Kotlin " +
                "DEMO数据1","Kotlin DEMO数据1","Kotlin DEMO数据17"))
    }
}
