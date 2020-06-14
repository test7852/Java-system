package com.ht.dao.education;

import com.ht.bean.education.Course;
import com.ht.bean.education.Trial;
import com.ht.bean.emp.Empinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/12 10:36
 * 
 */
public interface TrialMapper {
    int deleteByPrimaryKey(Integer trialid);

    int insert(Trial record);

    int insertSelective(Trial record);

    Trial selectByPrimaryKey(Integer trialid);

    int updateByPrimaryKeySelective(Trial record);

    int updateByPrimaryKey(Trial record);

    int selTroal();//查询总数据

    List<Trial> selbypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);//分页查询

    List<Course> selCou();//查询课程管理

    List<Empinfo> selEmp();//查询员工
}