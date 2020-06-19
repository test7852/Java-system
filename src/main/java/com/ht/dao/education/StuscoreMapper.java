package com.ht.dao.education;

import com.ht.bean.education.Stuscore;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
public interface StuscoreMapper {
    int deleteByPrimaryKey(Integer ssid);

    int insert(Stuscore record);

    int insertSelective(Stuscore record);

    Stuscore selectByPrimaryKey(Integer ssid);

    int updateByPrimaryKeySelective(Stuscore record);

    int updateByPrimaryKey(Stuscore record);
}