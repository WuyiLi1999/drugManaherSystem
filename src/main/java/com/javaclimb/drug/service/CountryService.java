package com.javaclimb.drug.service;

import com.javaclimb.drug.entity.Country;

import java.util.List;

/**
 * @author Smile
 */
public interface CountryService {

    List<String> getCountryName();
    List<Country> getCountryList();
}
