package com.ht.dao.student;

import com.ht.bean.student.Studentfall;

/**
 * @author 王金宝
 * @date 2020/6/15 16:02
 * 
 */
public interface StudentfallMapper {
    int deleteByPrimaryKey(Integer fallid);

    int insert(Studentfall record);

    int insertSelective(Studentfall record);

    Studentfall selectByPrimaryKey(Integer fallid);

    int updateByPrimaryKeySelective(Studentfall record);

    int updateByPrimaryKey(Studentfall record);
}