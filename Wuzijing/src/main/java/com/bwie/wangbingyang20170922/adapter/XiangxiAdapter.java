package com.bwie.wangbingyang20170922.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangbingyang20170922.R;
import com.bwie.wangbingyang20170922.bean.XiangxiBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 作者：王兵洋 on 2017/9/22 09:55
 * 类的作用： 详细信息的适配器
 */
public class XiangxiAdapter extends RecyclerView.Adapter<XiangxiAdapter.ViewHolder> {

    private Context context;
    private List<XiangxiBean.StoriesBean> storiesBeen;

    public XiangxiAdapter(Context context, List<XiangxiBean.StoriesBean> editorsBeen) {
        this.context = context;
        this.storiesBeen = editorsBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.xiangxiadapter, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.xiangxi_tv.setText(storiesBeen.get(position).getTitle());
        ImageLoader.getInstance().displayImage(storiesBeen.get(position).getImages() + "0", holder.xiangxi_img);
        if (storiesBeen.get(position).getImages() == null) {
            holder.xiangxi_img.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return storiesBeen != null ? storiesBeen.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView xiangxi_tv;
        ImageView xiangxi_img;

        public ViewHolder(View itemView) {
            super(itemView);
            xiangxi_tv = itemView.findViewById(R.id.xiangxi_tv);
            xiangxi_img = itemView.findViewById(R.id.xiangxi_img);
        }
    }
}
