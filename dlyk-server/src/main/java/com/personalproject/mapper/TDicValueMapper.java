package com.personalproject.mapper;

import com.personalproject.model.TDicValue;

public interface TDicValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TDicValue record);

    int insertSelective(TDicValue record);

    TDicValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDicValue record);

    int updateByPrimaryKey(TDicValue record);
}