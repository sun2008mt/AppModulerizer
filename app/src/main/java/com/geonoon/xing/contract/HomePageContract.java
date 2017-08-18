package com.geonoon.xing.contract;

import com.genoon.library.presenter.BasePresenter;
import com.genoon.library.view.BaseView;
import com.geonoon.xing.model.db.entity.minimalist.Weather;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 */
public interface HomePageContract {

    interface View extends BaseView<Presenter> {

        void displayWeatherInformation(Weather weather);
    }

    interface Presenter extends BasePresenter {

        void loadWeather(String cityId, boolean refreshNow);
    }
}
