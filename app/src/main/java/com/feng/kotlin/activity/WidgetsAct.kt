package com.feng.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.feng.kotlin.R
import org.jetbrains.anko.*

/**
 * Kotlin扔掉xml布局，代码实现界面功能
 *
 * @author ldm
 * @description：
 * @date 2016-8-4 下午16:31:25
 */
class WidgetsAct : AppCompatActivity() {
    //定义一个集合变量，并赋值
    private val items = listOf("点击进入RecycleView","点击弹出Dialog")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //创建一个垂直的LinearLayout
        verticalLayout {
            //设置布局padding属性
            padding = dip(16)
            //定义一个ListView
            val lisetview = listView() {
                //设置适配器
                adapter = ArrayAdapter<String>(this@WidgetsAct, android.R.layout.simple_list_item_1, items)
                //实现ListView的onItemClickListener点击事件
                onItemClickListener = object : AdapterView.OnItemClickListener {
                    override fun onItemClick(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
                        when (position) {
                            0 -> {//点击第1条数据时跳转，点击其它数据没反应，可以进行指定跳转的判断操作
                                //跳转到指定页面
                                startActivity<RecycleViewAct>()
                            }
                            1 -> {
                                //点击弹出Dialog
                                val dialog = alert {
                                    title(R.string.title)//设置对话框标题
                                    message(R.string.content)//设置对话框内容
                                    positiveButton {}//设置对话框按钮
                                }.show()
                            }
                        }
                    }
                }
            }.lparams(width = matchParent) {height = wrapContent}
            //我们再定义一个SeekBar
            val seekbar = seekBar() {
                //SeekBar监听事件
                onSeekBarChangeListener {
                    //监听值变化
                    onProgressChanged { seekBar, progress, fromUser ->
                        //通过toast方法弹出文字
                        toast("当前值：" + seekBar?.progress)
                    }
                }
            }.lparams(width = matchParent) { height = wrapContent;topMargin = dip(10) }
            //再定义一个EditText
            var editText = editText { hintResource = R.string.edit_hint }
                    .lparams(width = matchParent) { height = wrapContent;topMargin = dip(10) }
            //定义一个Button,来监听EditText文字是否为空
            button("点击试试") { onClick { toast("您输入的是：" + editText.text) } }
                    .lparams(width = matchParent) { height = wrapContent;topMargin = dip(10) }
                    .setTextSize(16f)
        }

    }
}
