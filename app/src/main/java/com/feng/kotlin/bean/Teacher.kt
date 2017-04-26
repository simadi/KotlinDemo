package com.feng.kotlin.bean

import java.util.*

/**
 * 数据库表Teacher对应地实体类
 * @author ldm
 * @description：
 * @date 2016-8-8  上午10:40:12
 */
class Teacher(var map: MutableMap<String, Any?>) {

    var _id: String by map //教师ID
    var name: String by map   //教师名称
    var subject: String by map     //教学科目
    var level: Int by map      //教学水平


    constructor(name: String, subject: String, level: Int) : this(HashMap()) {
        this.name = name
        this.level = level
        this.subject = subject
    }
}
