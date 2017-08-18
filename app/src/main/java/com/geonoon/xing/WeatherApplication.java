package com.geonoon.xing;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.support.compat.BuildConfig;
import android.util.Log;

import com.geonoon.xing.model.http.ApiClient;
import com.geonoon.xing.model.http.ApiConstants;
import com.geonoon.xing.model.http.configuration.ApiConfiguration;

/**
 * 
 *
 * @author: Marc SUN
 * @email: 710641245@qq.com
 * @created: 17-8-18 下午5:14
 * 
 */
public class WeatherApplication extends Application {

    private static final String TAG = "WeatherApp";

    private ApplicationComponent applicationComponent;

    private static WeatherApplication weatherApplicationInstance;

    public static WeatherApplication getInstance() {

        return weatherApplicationInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "attachBaseContext");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate start");
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        //初始化Stetho
        BuildConfig.STETHO.init(this.getApplicationContext());

        weatherApplicationInstance = this;

        //初始化ApiClient
        ApiConfiguration apiConfiguration = ApiConfiguration.builder()
//                .dataSourceType(ApiConstants.WEATHER_DATA_SOURCE_TYPE_MI)
//                .dataSourceType(ApiConstants.WEATHER_DATA_SOURCE_TYPE_KNOW)
                .dataSourceType(ApiConstants.WEATHER_DATA_SOURCE_TYPE_ENVIRONMENT_CLOUD)
                .build();
        ApiClient.init(apiConfiguration);
        Log.d(TAG, "onCreate end");
    }


    public ApplicationComponent getApplicationComponent() {

        return applicationComponent;
    }
}
