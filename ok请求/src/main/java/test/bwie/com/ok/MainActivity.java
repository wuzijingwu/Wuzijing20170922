package test.bwie.com.ok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements NetDataCallBack {

    private ImageView imageView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv2);
        listView = (ListView) findViewById(R.id.lv);
        String url = "http://news-at.zhihu.com/api/4/news/latest";
        OKutils oKutils = new OKutils();
        oKutils.getdata("url",this,Data.class);


    }

    @Override
    public void success(Object o) {



    }

    @Override
    public void field(int position, String str) {

    }
}
