package com.bwie.wangbingyang20170922.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wangbingyang20170922.R;
import com.bwie.wangbingyang20170922.bean.NewsBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 作者：王兵洋 on 2017/9/22 09:55
 * 类的作用： 新闻日报的适配器
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<NewsBean.TopStoriesBean> storiesBeen;

    public NewsAdapter(Context context, List<NewsBean.TopStoriesBean> storiesBeen) {
        this.context = context;
        this.storiesBeen = storiesBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.newsadapter, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.news_tv.setText(storiesBeen.get(position).getTitle());
        ImageLoader.getInstance().displayImage(storiesBeen.get(position).getImage(), holder.news_img);
    }

    @Override
    public int getItemCount() {
        return storiesBeen != null ? storiesBeen.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView news_tv;
        ImageView news_img;

        public ViewHolder(View itemView) {
            super(itemView);
            news_tv = itemView.findViewById(R.id.news_tv);
            news_img = itemView.findViewById(R.id.news_img);
        }
    }
}
