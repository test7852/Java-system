package com.ht.service;

import com.ht.bean.Dept;
    /**
 * @author lrq
 * @date 2020/6/7 19:22
 */
public interface DeptService{


    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

}
