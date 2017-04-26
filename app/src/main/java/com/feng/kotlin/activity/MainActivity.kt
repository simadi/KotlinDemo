package com.feng.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.feng.kotlin.R
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity

import kotlinx.android.synthetic.main.activity_main.*
/**
 * Kotlin项目主界面
 *
 * @author ldm
 * @description：
 * @date 2016-8-4 下午15:12:47
 */
class MainActivity : AppCompatActivity() {
    //通过val关键字定义变量
    /*var widgets_btn: Button? = null;
    var json_btn: Button? = null;
    var http_btn: Button? = null;
    var db_btn: Button? = null;*/
    //实现onCreate(）方法，关键字“fun”
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //不好意思，进来就弹出一个对话框
 /*      alert {
            title(R.string.first_tips)
            message(R.string.first_tips_contnet)
            positiveButton {
            }
        }.show()*/
        //findViews();
        initListeners();
    }

    /**
     * 初始化控件

    fun findViews() {
        widgets_btn = findViewById(R.id.widgets_btn) as Button;
        json_btn = findViewById(R.id.json_btn) as Button;
        http_btn = findViewById(R.id.http_btn) as Button;
        db_btn = findViewById(R.id.db_btn) as Button;
    }*/

    /**
     * 按钮监听事件
     */
    private fun initListeners() {
        //实现点击后跳转到对应页面
        //调用startActivity方法需要在项目中添加Anko相应资源
        //startActivity<TabDemo1>()是Anko的语法,等价于java中startActivity(MainActivity.this, HttpAct.class)
        widgets_btn?.setOnClickListener {startActivity<WidgetsAct>()}
        json_btn?.setOnClickListener {startActivity<JsonAct>()}
        http_btn?.setOnClickListener {startActivity<HttpAct>()}
        db_btn?.setOnClickListener {startActivity<DBTestAct>()}
        Picasso_btn?.setOnClickListener {startActivity<PicassoActivity>()}
    }
}
