package com.qf.day6.service;

import com.qf.day6.entity.Province;

import java.util.Arrays;
import java.util.List;

public class ProvinceService {
    public List<Province> findAll(){
        return Arrays.asList(
                new Province(1, "湖北")
                , new Province(2, "湖南")
        );
    }
}
