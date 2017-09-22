package com.bwie.wangbingyang20170922.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * 作者：王兵洋 on 2017/9/22 09:23
 * 类的作用：
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context).load(path).into(imageView);
        Uri uri = Uri.parse((String) path);
        imageView.setImageURI(uri);
    }
}