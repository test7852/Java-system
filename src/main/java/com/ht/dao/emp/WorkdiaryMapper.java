package com.ht.dao.emp;

import com.ht.bean.emp.Workdiary;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/12 20:30
 * 
 */
public interface WorkdiaryMapper {

    int selworkcount();//查询总数

    List<Workdiary> allPageWorkdiary(Pager pager);

    int deleteByPrimaryKey(Integer worklogid);

    int insert(Workdiary record);

    int insertSelective(Workdiary record);

    Workdiary selectByPrimaryKey(Integer worklogid);

    int updateByPrimaryKeySelective(Workdiary record);

    int updateByPrimaryKey(Workdiary record);
}