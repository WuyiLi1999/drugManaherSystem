package com.javaclimb.drug.mapper;

import com.javaclimb.drug.entity.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {
    List<String> getCountryName();

    List<Country> getCountryList();
}
