package com.ht.dao.education;

import com.ht.bean.education.Dept;

/**
 * @author lrq
 * @date 2020/6/7 19:22
 */
public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}