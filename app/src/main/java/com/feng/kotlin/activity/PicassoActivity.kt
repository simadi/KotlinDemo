package com.feng.kotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.feng.kotlin.R
import com.feng.kotlin.adapter.ImageListAdapter
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : AppCompatActivity() {

    var imageUrls = arrayOf("http://i.imgur.com/rFLNqWI.jpg","http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg","http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg","http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg","http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg","http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg","http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg","http://i.imgur.com/Z3QjilA.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        lv.setAdapter(ImageListAdapter(this, imageUrls))
    }
}
