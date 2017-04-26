package com.feng.kotlin.bean

import java.util.*

/**
 * 数据库表Student对应地实体类
 * @author ldm
 * @description：
 * @date 2016-8-8  上午10:40:12
 */

class Student(var map: MutableMap<String, Any?>) {
    var _id: String by map //学生ID
    var name: String by map   //学生名称
    var sex: String by map     //学生性别
    var age: Int by map      //学生年龄
    var score: String by map //学生成绩
    var teacherId: String by map //对应教师id

    constructor(name: String, sex: String, age: Int, score: String, teacherId: String) : this(HashMap()) {
        this.name = name
        this.sex = sex
        this.score = score
        this.teacherId = teacherId
        this.age = age;
    }
}
