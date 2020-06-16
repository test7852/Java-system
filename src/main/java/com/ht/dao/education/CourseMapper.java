package com.ht.dao.education;

import com.ht.bean.education.Course;
import com.ht.bean.education.Coursetype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/8 20:35
 *  
 */
@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    int selCountcEdu();//查询总数据

    List<Map> selbypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);//分页查询

    List<Coursetype> selCtype();//查询课程类别

    List<Course> selCourse();//查询课程类别

}