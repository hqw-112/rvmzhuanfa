package com.winter.mapper;

import com.winter.model.ParseRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParseRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ParseRule record);

    int insertSelective(ParseRule record);

    ParseRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ParseRule record);

    int updateByPrimaryKey(ParseRule record);

    List<ParseRule> getByPid(int id);

    void inserts(@Param("list") List<ParseRule> pr);
}