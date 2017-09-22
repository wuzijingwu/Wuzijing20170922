package com.bwie.wangbingyang20170922.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.wangbingyang20170922.R;
import com.bwie.wangbingyang20170922.bean.ZTBean;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 作者：王兵洋 on 2017/9/22 09:55
 * 类的作用：主题日报的适配器
 */
public class ZTAdapter extends RecyclerView.Adapter<ZTAdapter.ViewHolder> {

    private Context context;
    private List<ZTBean.OthersBean> othersBeen;
    private OnItemClickLitener mOnItemClickLitener;

    public ZTAdapter(Context context, List<ZTBean.OthersBean> othersBeen) {
        this.context = context;
        this.othersBeen = othersBeen;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.ztadapter, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.zt_tv.setText(othersBeen.get(position).getName());
//        ImageLoader.getInstance().displayImage(othersBeen.get(position).getThumbnail(), holder.zt_img);
        Glide.with(context).load(othersBeen.get(position).getThumbnail())
                .bitmapTransform(new CropCircleTransformation(context))
                .into(holder.zt_img);
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return othersBeen != null ? othersBeen.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView zt_tv;
        ImageView zt_img;

        public ViewHolder(View itemView) {
            super(itemView);
            zt_tv = itemView.findViewById(R.id.zt_tv);
            zt_img = itemView.findViewById(R.id.zt_img);
        }
    }
}
