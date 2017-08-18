package com.geonoon.xing.contract;

import com.genoon.library.presenter.BasePresenter;
import com.genoon.library.view.BaseView;
import com.geonoon.xing.model.db.entity.City;

import java.util.List;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 */
public interface SelectCityContract {

    interface View extends BaseView<Presenter> {

        void displayCities(List<City> cities);
    }

    interface Presenter extends BasePresenter {

        void loadCities();
    }
}
