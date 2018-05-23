package com.winter.mapper;

import com.winter.model.PlatformUser;

import java.util.List;

public interface PlatformUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    PlatformUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByPrimaryKey(PlatformUser record);
    List<PlatformUser> selectAll();
}