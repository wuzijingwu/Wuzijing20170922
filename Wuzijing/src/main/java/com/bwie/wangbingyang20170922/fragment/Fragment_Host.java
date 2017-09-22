package com.bwie.wangbingyang20170922.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.wangbingyang20170922.R;

/**
 * 作者：王兵洋 on 2017/9/22 09:00
 * 类的作用：
 */
public class Fragment_Host extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_s, null);
        return view;
    }
}
