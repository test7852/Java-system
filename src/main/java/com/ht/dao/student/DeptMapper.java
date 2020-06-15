package com.ht.dao.student;

import com.ht.bean.student.Dept;

/**
 * @author 王金宝
 * @date 2020/6/15 16:00
 * 
 */
public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}