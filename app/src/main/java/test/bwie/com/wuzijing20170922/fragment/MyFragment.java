package test.bwie.com.wuzijing20170922.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import test.bwie.com.wuzijing20170922.R;
import test.bwie.com.wuzijing20170922.bean.ReadInfo;
import test.bwie.com.wuzijing20170922.read.StreamInfo;

/**
 * Created by dell on 2017/9/22.
 */

public class MyFragment extends Fragment implements XRecyclerView.LoadingListener {

    private View view;
    private ViewPager viewpagers;
    private XRecyclerView recyclerview;
    private ArrayList<String> list;
    private int index = 0;
    private static final int TAG = 12;
    private Timer timer;
    private ImageLoader imageLoader;
    private int p = 20131119;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        return view;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG:
                    int index = (int) msg.obj;
                    viewpagers.setCurrentItem(index);
                    break;
            }
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();
        list.add("https://pic3.zhimg.com/v2-fbcc987cdb97f8e1859768945dbc4032.jpg");
        list.add("https://pic2.zhimg.com/v2-0c5475d56e9cca912f1a75056ee6e2f1.jpg");
        list.add("https://pic1.zhimg.com/v2-9fc6920af0087ab3db94ab47c3f7f260.jpg");
        list.add("https://pic1.zhimg.com/v2-3ec07817ea4cc7b1f57066d8426e05d0.jpg");
        list.add("https://pic2.zhimg.com/v2-f3b974264dcb13bf56099126785afcf1.jpg");
        viewpagers = view.findViewById(R.id.viewpagers);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (index < list.size() - 1) {
                    index++;
                } else if (index == list.size() - 1) {
                    index = 0;
                }
                Message msg = new Message();
                msg.what = TAG;
                msg.obj = index;
                handler.sendMessage(msg);
            }
        }, 0, 1000);

        recyclerview = view.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(manager);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerview.setLoadingListener(this);
        recyclerview.setPullRefreshEnabled(true);
        recyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallPulseRise);


        getDates("http://news-at.zhihu.com/api/4/news/before/20131119", p + "");


    }


    @Override
    public void onRefresh() {
        p++;
        getDates("http://news-at.zhihu.com/api/4/news/before/20131119", p + "");
        recyclerview.refreshComplete();


    }

    @Override
    public void onLoadMore() {
        p++;
        getDates("http://news-at.zhihu.com/api/4/news/before/20131119", p + "");
        recyclerview.loadMoreComplete();
    }


    public void getDates(String path, String p) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s != null) {
                    Gson gson = new Gson();
                    ReadInfo readInfo = gson.fromJson(s, ReadInfo.class);
                    List<ReadInfo.StoriesBean> stories = readInfo.getStories();
                    recyclerview.setAdapter(new Myasdapter(stories));
                }
            }

            @Override
            protected String doInBackground(String... strings) {

                try {
                    String path = strings[0];
                    String p = strings[1];

                    URL url = new URL(path);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(200);
                    urlConnection.setReadTimeout(200);
                    int code = urlConnection.getResponseCode();
                    if (code == 200) {
                        InputStream is = urlConnection.getInputStream();
                        String json = StreamInfo.read(is);
                        return json;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute(path, p);

    }

    public class Myasdapter extends RecyclerView.Adapter<Myasdapter.MyViewHolder> {

        List<ReadInfo.StoriesBean> stories;
        private final DisplayImageOptions options;

        public Myasdapter(List<ReadInfo.StoriesBean> stories) {
            this.stories = stories;
            imageLoader = ImageLoader.getInstance();
            File file = new File(Environment.getExternalStorageDirectory(), "Bwei");
            if (!file.exists())
                file.mkdirs();

            ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getActivity())
                    .diskCache(new UnlimitedDiskCache(file))
                    .build();

            imageLoader.init(configuration);

            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .cacheOnDisk(true)
                    .build();


        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itme, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.text.setText(stories.get(position).getTitle());
            getimage(stories.get(position).getImages().get(0), holder.imaged);
        }

        @Override
        public int getItemCount() {
            return stories.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private final TextView text;
            private final ImageView imaged;

            public MyViewHolder(View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
                imaged = itemView.findViewById(R.id.imaged);
            }


        }


    }

    public void getimage(String path, ImageView imageView) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();
        ImageLoader.getInstance().displayImage(path, imageView, options);


    }


}
