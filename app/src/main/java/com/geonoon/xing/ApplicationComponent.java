package com.geonoon.xing;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 
 *
 * @author: Marc SUN
 * @email: 710641245@qq.com
 * @created: 17-8-18 下午5:18
 * 
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    WeatherApplication getApplication();

    Context getContext();
}
