package com.ht.dao.education;

import com.ht.bean.education.Course;

/**
 * @author 王金宝
 * @date 2020/6/8 20:35
 *  
 */
public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}