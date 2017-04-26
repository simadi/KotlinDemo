package com.feng.kotlin.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.feng.kotlin.R;
import com.squareup.picasso.Picasso;

/**
 * Created by feng on 2017/4/14.
 */
public class ImageListAdapter extends ArrayAdapter {

    private Context context;
    private String[] imageUrls;

    public ImageListAdapter(Context context,String[] imageUrls){
        super(context, R.layout.item_picasso,imageUrls);
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = View.inflate(context,R.layout.item_picasso,null);
        }
        //加载图片
        Picasso.with(context).load(imageUrls[position]).into((ImageView) convertView);
        return convertView;
    }
}