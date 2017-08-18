package com.geonoon.xing.activity.component;

import com.geonoon.xing.ApplicationComponent;
import com.geonoon.xing.activity.SelectCityActivity;
import com.geonoon.xing.activity.module.SelectCityModule;
import com.geonoon.xing.util.stetho.ActivityScoped;

import dagger.Component;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         2016/11/30
 */
@ActivityScoped
@Component(modules = SelectCityModule.class, dependencies = ApplicationComponent.class)
public interface SelectCityComponent {

    void inject(SelectCityActivity selectCityActivity);
}
