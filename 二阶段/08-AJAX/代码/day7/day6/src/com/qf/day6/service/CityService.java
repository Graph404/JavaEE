package com.qf.day6.service;

import com.qf.day6.entity.City;

import java.util.Arrays;
import java.util.List;

public class CityService {
    public List<City> findAllByProvinceId(Integer id){
        if (id == 1){
            return Arrays.asList(
                    new City(1, "武汉")
                    , new City(2, "黄石")
            );
        }else if (id == 2){
            return Arrays.asList(
                    new City(3, "长沙")
                    , new City(4, "岳阳")
            );
        }else {
            return null;
        }
    }
}
