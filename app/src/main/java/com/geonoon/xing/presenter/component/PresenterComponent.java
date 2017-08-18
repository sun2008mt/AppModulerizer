package com.geonoon.xing.presenter.component;

import com.geonoon.xing.ApplicationModule;
import com.geonoon.xing.presenter.DrawerMenuPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 
 *
 * @author: Marc SUN
 * @email: 710641245@qq.com
 * @created: 17-8-18 下午5:13
 * 
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface PresenterComponent {

//    void inject(HomePagePresenter presenter);
//
//    void inject(SelectCityPresenter presenter);

    void inject(DrawerMenuPresenter presenter);
}
 