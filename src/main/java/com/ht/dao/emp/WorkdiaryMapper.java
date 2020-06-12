package com.ht.dao.emp;

import com.ht.bean.emp.Workdiary;

/**
 * @author 王金宝
 * @date 2020/6/12 20:30
 * 
 */
public interface WorkdiaryMapper {
    int deleteByPrimaryKey(Integer worklogid);

    int insert(Workdiary record);

    int insertSelective(Workdiary record);

    Workdiary selectByPrimaryKey(Integer worklogid);

    int updateByPrimaryKeySelective(Workdiary record);

    int updateByPrimaryKey(Workdiary record);
}