package com.feng.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

import com.feng.kotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_http.*
import org.jetbrains.anko.ctx

/**
 * Kotlin中进行网络请求
 *记得在AndroidManifest.xml中添加INTENT权限
 * @author ldm
 * @description：
 * @date 2016-8-6 下午13:56:41
 */
class HttpAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        val imageUrls = listOf("http://avatar.csdn.net/F/5/F/1_feifei454498130.jpg","http://upload.jianshu.io/users/upload_avatars/414738/8385b70c13e0.jpg")
        val ivs= listOf<ImageView>(kotlin_iv_one,kotlin_iv_two)
        ivs.forEachIndexed{i,v ->LoadImage(imageUrls[i],v) }
    }

    //通过Picasso框架加载网络图片
    fun LoadImage(imageUrl:String,iv:ImageView){
        Picasso.with(ctx).load(imageUrl).into(iv)
    }
    //TODO
    //Volley、KJFrameForAndroid、OKHttp等开发框架，在Kotlin语言下依旧能正常运行。
    //待断续完善在Kotlin中使用Volley
}
