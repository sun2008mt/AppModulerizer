package com.geonoon.xing.contract;

import com.genoon.library.presenter.BasePresenter;
import com.genoon.library.view.BaseView;
import com.geonoon.xing.model.db.entity.minimalist.Weather;
import com.geonoon.xing.presenter.DrawerMenuPresenter;

import java.io.InvalidClassException;
import java.util.List;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         16/4/16
 */
public interface DrawerContract {

    interface View extends BaseView<DrawerMenuPresenter> {

        void displaySavedCities(List<Weather> weatherList);
    }

    interface Presenter extends BasePresenter {

        void loadSavedCities();

        void deleteCity(String cityId);

        void saveCurrentCityToPreference(String cityId) throws InvalidClassException;
    }
}
