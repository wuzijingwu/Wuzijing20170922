package test.bwie.com.ok;

/**
 * Created by dell on 2017/9/22.
 */


public interface NetDataCallBack<T> {
    void success(T t);

    void field(int position, String str);

}


