package com.feng.kotlin.activity

import android.content.ContentValues
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.feng.kotlin.R
import com.feng.kotlin.db.DBHelper

import org.jetbrains.anko.*
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.select
import java.util.*

/**
 * Kotlin中进行数据库操作
 * @author ldm
 * @description：
 * @date 2016-8-6 下午14:40:12
 */
class DBTestAct : AppCompatActivity() {
    var db: DBHelper = DBHelper(ctx)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //通过这种方式来打开DbHelper
var newId=0L;
        verticalLayout {
            padding = dip(16)
            //添加学生数据的表
            button(getString(R.string.add_stu)) {
                onClick {
                    //获取到所有的学生列表
                    //var stuList = db.writableDatabase.select(DBHelper.StudentTable.T_NAME).parseList { Student(HashMap(it)) }
                    //插入一条学生数据
                    var values: ContentValues = ContentValues()
                    values.put(DBHelper.StudentTable.NAME, "New学生")
                    values.put(DBHelper.StudentTable.AGE, 21)
                    values.put(DBHelper.StudentTable.SCORE, "85")
                    values.put(DBHelper.StudentTable.TEACHER_ID, "18")
                    values.put(DBHelper.StudentTable.SEX, "male")
                    //插入成功就返回记录的id否则返回-1；
                    newId = db.writableDatabase.insert(DBHelper.StudentTable.T_NAME, null, values);//当然还有其它更简单方法可以实现同样功能
                    var msg= if (newId >-1) ("成功，id=" + newId) else "失败！"
                    toast("插入"+msg)
                }
            }.lparams(width = matchParent) {height = wrapContent;topMargin = dip(10)}.setTextSize(16f)
            //修改学生表数据
            button(getString(R.string.update_stu)) {
                onClick {
                    //把学生id=5的数据进行修改
                    var dailyRequest = DBHelper.StudentTable.ID + " = ?"
                    var dir = arrayOf(newId.toString())

                    var values: ContentValues = ContentValues()
                    values.put(DBHelper.StudentTable.NAME, "Update学生")
                    values.put(DBHelper.StudentTable.AGE, 18)
                    values.put(DBHelper.StudentTable.SCORE, "62")
                    values.put(DBHelper.StudentTable.TEACHER_ID, "18")

                   val rowsAffected= db.writableDatabase.update(DBHelper.StudentTable.T_NAME, values, dailyRequest, dir);
                    var msg= if (rowsAffected >0) ("成功") else "失败！"
                    toast("更改"+msg)
                }
            }.lparams(width = matchParent) {height = wrapContent;topMargin = dip(10)}.setTextSize(16f)

            //查询数据库示例
            button(getString(R.string.query_stu)) {
                onClick {
                    //获取到所有的学生列表
                    var stuList = db.writableDatabase.select(DBHelper.StudentTable.T_NAME).parseList { (HashMap(it)) }
                    toast("共有"+stuList.size.toString()+"条数据")
                    //查询用户id==5的学生
                    //db.writableDatabase.select(DBHelper.StudentTable.T_NAME).whereSimple("${DBHelper.StudentTable.ID} = ?", "5").parseOpt {Student(HashMap(it))}
                }
            }.lparams(width = matchParent) {height = wrapContent;topMargin = dip(10)}.setTextSize(16f)

            //删除学生表数据
            button(getString(R.string.del_stu)) {
                onClick {
                    var dailyRequest = DBHelper.StudentTable.ID + " ="+newId
                    //删除id=5的学生数据
                   var rowsAffected= db.writableDatabase.delete(DBHelper.StudentTable.T_NAME, dailyRequest)
                    var msg= if (rowsAffected >0) ("成功") else "失败！"
                    toast("删除"+msg)
                }
            }.lparams(width = matchParent) {height = wrapContent;topMargin = dip(10)}.setTextSize(16f)
        }
    }

    //返回数据集合
    fun <T : Any> SelectQueryBuilder.parseList(
            parser: (Map<String, Any>) -> T): List<T> =
            parseList(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any>): T = parser(columns)
            })

    //返回可以为null对象，parseSingle效果一样，但是返回不能为null
    fun <T : Any> SelectQueryBuilder.parseOpt(
            parser: (Map<String, Any>) -> T): T? =
            parseOpt(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any>): T = parser(columns)
            })

}
