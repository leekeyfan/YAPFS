package cn.com.leco.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.lidroid.xutils.HttpUtils;

public class YH_Activity extends AppCompatActivity {
    public HttpUtils httpUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpUtils = HttpUtils_Base.httpUtils;

    }
}
