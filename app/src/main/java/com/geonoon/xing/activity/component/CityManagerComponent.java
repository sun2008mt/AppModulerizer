package com.geonoon.xing.activity.component;

import com.geonoon.xing.ApplicationComponent;
import com.geonoon.xing.activity.CityManagerActivity;
import com.geonoon.xing.activity.module.DrawerMenuModule;
import com.geonoon.xing.util.stetho.ActivityScoped;

import dagger.Component;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         2016/11/30
 */
@ActivityScoped
@Component(modules = DrawerMenuModule.class, dependencies = ApplicationComponent.class)
public interface CityManagerComponent {

    void inject(CityManagerActivity cityManagerActivity);
}
