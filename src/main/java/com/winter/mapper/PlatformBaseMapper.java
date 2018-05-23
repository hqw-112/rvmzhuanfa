package com.winter.mapper;

import com.winter.model.PlatformBase;

public interface PlatformBaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformBase record);

    int insertSelective(PlatformBase record);

    PlatformBase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformBase record);

    int updateByPrimaryKey(PlatformBase record);

    PlatformBase getByCode(String name);
}