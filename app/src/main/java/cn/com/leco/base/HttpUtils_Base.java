package cn.com.leco.base;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.util.PreferencesCookieStore;

public class HttpUtils_Base {

    public static HttpUtils httpUtils = init();

    private static PreferencesCookieStore cookieStore;

    private static HttpUtils init() {

        if (httpUtils == null) {
            httpUtils = new HttpUtils();

            if (cookieStore != null) {
                httpUtils.configCookieStore(cookieStore);
            } else {
                cookieStore = new PreferencesCookieStore(App_Application.getContext());
                httpUtils.configCookieStore(cookieStore);
            }
        }
        return httpUtils;
    }


}
