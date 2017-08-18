package com.geonoon.xing.activity.module;

import com.geonoon.xing.contract.DrawerContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         2016/11/30
 */
@Module
public class DrawerMenuModule {

    private DrawerContract.View view;

    public DrawerMenuModule(DrawerContract.View view) {
        this.view = view;
    }

    @Provides
    DrawerContract.View provideCityManagerContactView() {
        return view;
    }
}
