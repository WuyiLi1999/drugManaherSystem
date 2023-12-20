package com.javaclimb.drug.service.impl;


import com.javaclimb.drug.entity.Country;
import com.javaclimb.drug.mapper.CountryMapper;
import com.javaclimb.drug.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl<CountryServiceMapper> implements CountryService {
    @Autowired
    private CountryMapper countryMapper;
    @Override
    public List<String> getCountryName() {

        return countryMapper.getCountryName();
    }

    @Override
    public List<Country> getCountryList() {
        return countryMapper.getCountryList();
    }
}
