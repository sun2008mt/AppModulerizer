package com.geonoon.xing.model.db.entity.adapter;

import com.geonoon.xing.model.db.entity.minimalist.AirQualityLive;
import com.geonoon.xing.model.db.entity.minimalist.LifeIndex;
import com.geonoon.xing.model.db.entity.minimalist.Weather;
import com.geonoon.xing.model.db.entity.minimalist.WeatherForecast;
import com.geonoon.xing.model.db.entity.minimalist.WeatherLive;

import java.util.List;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         16/2/25
 */
public abstract class WeatherAdapter {

    public abstract String getCityId();

    public abstract String getCityName();

    public abstract String getCityNameEn();

    public abstract WeatherLive getWeatherLive();

    public abstract List<WeatherForecast> getWeatherForecasts();

    public abstract List<LifeIndex> getLifeIndexes();

    public abstract AirQualityLive getAirQualityLive();

    public Weather getWeather() {

        Weather weather = new Weather();
        weather.setCityId(getCityId());
        weather.setCityName(getCityName());
        weather.setCityNameEn(getCityNameEn());
        weather.setAirQualityLive(getAirQualityLive());
        weather.setWeatherForecasts(getWeatherForecasts());
        weather.setLifeIndexes(getLifeIndexes());
        weather.setWeatherLive(getWeatherLive());
        return weather;
    }
}
