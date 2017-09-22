package com.bwie.wangbingyang20170922.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.wangbingyang20170922.R;
import com.bwie.wangbingyang20170922.XiangxiActivity;
import com.bwie.wangbingyang20170922.adapter.ZTAdapter;
import com.bwie.wangbingyang20170922.bean.ZTBean;
import com.bwie.wangbingyang20170922.utils.OkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * 作者：王兵洋 on 2017/9/22 09:00
 * 类的作用：
 */
public class Fragment_ZT extends Fragment {

    private RecyclerView mRy;
    private String path = "http://news-at.zhihu.com/api/4/themes";
    private List<ZTBean.OthersBean> othersBeen = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_si, null);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        OkHttp.getAsync(path, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                othersBeen.addAll(new Gson().fromJson(result, ZTBean.class).getOthers());
                ZTAdapter ztAdapter = new ZTAdapter(getActivity(), othersBeen);
                mRy.setAdapter(ztAdapter);
                ztAdapter.notifyDataSetChanged();
                ztAdapter.setOnItemClickLitener(new ZTAdapter.OnItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(new Intent(getActivity(), XiangxiActivity.class));
                    }
                });
            }
        });
    }

    private void initView(View view) {
        mRy = (RecyclerView) view.findViewById(R.id.ry);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRy.setLayoutManager(gridLayoutManager);
    }
}
