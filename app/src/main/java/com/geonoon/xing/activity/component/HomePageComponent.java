package com.geonoon.xing.activity.component;

import com.geonoon.xing.ApplicationComponent;
import com.geonoon.xing.activity.MainActivity;
import com.geonoon.xing.activity.module.HomePageModule;
import com.geonoon.xing.util.stetho.ActivityScoped;

import dagger.Component;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         2016/11/29
 */
@ActivityScoped
@Component(modules = HomePageModule.class, dependencies = ApplicationComponent.class)
public interface HomePageComponent {

    void inject(MainActivity mainActivity);
}
