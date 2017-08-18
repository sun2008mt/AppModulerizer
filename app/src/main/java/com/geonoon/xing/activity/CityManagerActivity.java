package com.geonoon.xing.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.genoon.library.activity.BaseActivity;
import com.genoon.library.util.ActivityUtils;
import com.genoon.xing.R;
import com.geonoon.xing.WeatherApplication;
import com.geonoon.xing.activity.component.DaggerCityManagerComponent;
import com.geonoon.xing.activity.module.DrawerMenuModule;
import com.geonoon.xing.presenter.DrawerMenuPresenter;
import com.geonoon.xing.view.fragment.DrawerMenuFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 */
public class CityManagerActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    DrawerMenuPresenter drawerMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        DrawerMenuFragment drawerMenuFragment = DrawerMenuFragment.newInstance(3);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), drawerMenuFragment, R.id.fragment_container);

        DaggerCityManagerComponent.builder()
                .applicationComponent(WeatherApplication.getInstance().getApplicationComponent())
                .drawerMenuModule(new DrawerMenuModule(drawerMenuFragment))
                .build().inject(this);
    }
}
