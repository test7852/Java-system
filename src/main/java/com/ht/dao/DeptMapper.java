package com.ht.dao;

import com.ht.bean.Dept;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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