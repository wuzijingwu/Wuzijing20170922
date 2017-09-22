package com.bwie.wangbingyang20170922.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.wangbingyang20170922.R;
import com.bwie.wangbingyang20170922.adapter.NewsAdapter;
import com.bwie.wangbingyang20170922.bean.NewsBean;
import com.bwie.wangbingyang20170922.utils.GlideImageLoader;
import com.bwie.wangbingyang20170922.utils.OkHttp;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * 作者：王兵洋 on 2017/9/22 09:00
 * 类的作用：新闻日报界面
 */
public class Fragment_News extends Fragment {

    private View mView;
    private String path = "http://news-at.zhihu.com/api/";
    int ins = 4;
    private String path2 = "/news/latest";

    private List<String> images = new ArrayList<>();
    private RecyclerView mRcy;
    private List<NewsBean.TopStoriesBean> storiesBeen = new ArrayList<>();
    private SwipeRefreshLayout mSw;
    private LinearLayoutManager linearLayoutManager;
    private NewsAdapter newsAdapter;
    private Banner banner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.fragment_y, null);
        initView(mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        images.add("https://pic3.zhimg.com/v2-9c1568aa03ca151eea4a587ee51802ea.jpg");
        images.add("https://pic1.zhimg.com/v2-05dc0ad139f217f283875815bc5538a0.jpg");
        images.add("https://pic2.zhimg.com/v2-a4ebecc5f3ac7845805b2d17688db35d.jpg");
        images.add("https://pic1.zhimg.com/v2-31c7577a439db633b92b2be42caf1e64.jpg");
        images.add("https://pic1.zhimg.com/v2-ccd5abcab2fe67c945245e1e8781d550.jpg");
        banner = (Banner) mView.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        initData();

        //上拉加载
        mSw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ins++;
                initData();
                //刷新适配器
                newsAdapter.notifyDataSetChanged();
                mSw.setRefreshing(false);
            }
        });
        //下拉加载
        mRcy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == storiesBeen.size() - 1) {
                    ins++;
                    initData();
                    newsAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        banner.startAutoPlay();
    }

    private void initData() {
        OkHttp.getAsync(path + ins + path2, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                storiesBeen.addAll(new Gson().fromJson(result, NewsBean.class).getTop_stories());
                newsAdapter = new NewsAdapter(getActivity(), storiesBeen);
                mRcy.setAdapter(newsAdapter);
            }
        });
    }

    private void initView(View mView) {
        mRcy = (RecyclerView) mView.findViewById(R.id.rcy);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRcy.setLayoutManager(linearLayoutManager);
        mSw = (SwipeRefreshLayout) mView.findViewById(R.id.sw);
    }
}