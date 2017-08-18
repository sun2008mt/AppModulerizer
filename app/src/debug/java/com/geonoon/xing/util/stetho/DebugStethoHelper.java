package com.geonoon.xing.util.stetho;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.genoon.library.util.StethoHelper;

import okhttp3.OkHttpClient;

/**
 * 
 *
 * @author: Marc SUN
 * @email: 710641245@qq.com
 * @created: 17-8-18 下午3:53
 * 
 */
public class DebugStethoHelper implements StethoHelper {

    @Override
    public void init(Context context) {
        Stetho.initializeWithDefaults(context);
    }

    @Override
    public OkHttpClient.Builder addNetworkInterceptor(OkHttpClient.Builder builder) {
        return builder.addNetworkInterceptor(new StethoInterceptor());
    }
}
