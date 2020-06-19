package com.ht.dao.aduit;

import com.ht.bean.aduit.Holiday;

/**
 * @author 王金宝
 * @date 2020/6/19 19:07
 * 
 */
public interface HolidayMapper {
    int deleteByPrimaryKey(Integer holidayid);

    int insert(Holiday record);

    int insertSelective(Holiday record);

    Holiday selectByPrimaryKey(Integer holidayid);

    int updateByPrimaryKeySelective(Holiday record);

    int updateByPrimaryKey(Holiday record);
}