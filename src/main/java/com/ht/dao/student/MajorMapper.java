package com.ht.dao.student;

import com.ht.bean.student.Major;

/**
 * @author 王金宝
 * @date 2020/6/15 20:29
 * 
 */
public interface MajorMapper {
    int deleteByPrimaryKey(Integer majorid);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer majorid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}