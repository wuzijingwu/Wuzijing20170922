package com.bwie.wangbingyang20170922;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.wangbingyang20170922.adapter.XiangxiAdapter;
import com.bwie.wangbingyang20170922.bean.XiangxiBean;
import com.bwie.wangbingyang20170922.utils.OkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class XiangxiActivity extends AppCompatActivity {

    private RecyclerView mRcy2;
    private List<XiangxiBean.StoriesBean> storiesBeen = new ArrayList<>();
    private String path = "http://news-at.zhihu.com/api/4/theme/11";
    private XiangxiAdapter xiangxiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangxi);
        initView();
        initData();

    }

    private void initData() {
        OkHttp.getAsync(path, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                storiesBeen.addAll(new Gson().fromJson(result, XiangxiBean.class).getStories());
                xiangxiAdapter = new XiangxiAdapter(XiangxiActivity.this, storiesBeen);
                mRcy2.setAdapter(xiangxiAdapter);
                xiangxiAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        mRcy2 = (RecyclerView) findViewById(R.id.rcy2);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRcy2.setLayoutManager(manager);
        storiesBeen.remove("[");
        storiesBeen.remove("]");

    }
}
