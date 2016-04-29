package cn.com.leco.main.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.leco.R;


public class TestFragment extends Fragment {

    private String title_Str=null;
    private TextView title;

    @SuppressLint("ValidFragment")
    public TestFragment(String title_Str) {
        this.title_Str = title_Str;

    }

    public TestFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_test, container, false);

        title = (TextView) v.findViewById(R.id.title);

        if (title_Str != null) {
            title.setText(title_Str);
        }

        return v;

    }
}
