package com.geonoon.xing.activity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.genoon.library.activity.BaseActivity;
import com.genoon.library.util.ActivityUtils;
import com.genoon.xing.R;
import com.geonoon.xing.WeatherApplication;
import com.geonoon.xing.activity.component.DaggerSelectCityComponent;
import com.geonoon.xing.activity.module.SelectCityModule;
import com.geonoon.xing.presenter.SelectCityPresenter;
import com.geonoon.xing.view.fragment.SelectCityFragment;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com ==>> baronzhang.com)
 */
public class SelectCityActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    SelectCityFragment selectCityFragment;

    @Inject
    SelectCityPresenter selectCityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        selectCityFragment = SelectCityFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), selectCityFragment, R.id.fragment_container);

        DaggerSelectCityComponent.builder()
                .applicationComponent(WeatherApplication.getInstance().getApplicationComponent())
                .selectCityModule(new SelectCityModule(selectCityFragment))
                .build().inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_city, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
            RxSearchView.queryTextChanges(searchView)
                    .map(charSequence -> charSequence == null ? null : charSequence.toString().trim())
                    .throttleLast(100, TimeUnit.MILLISECONDS)
                    .debounce(100, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(searchText -> selectCityFragment.cityListAdapter.getFilter().filter(searchText));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}