package test.bwie.com.wuzijing20170922.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import test.bwie.com.wuzijing20170922.R;

/**
 * Created by dell on 2017/9/22.
 */

public class Fragment3 extends Fragment  {

    private View inflate;
    private XRecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment3, container, false);
        return inflate;
    }


}
