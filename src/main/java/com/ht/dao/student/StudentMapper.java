package com.ht.dao.student;

import com.ht.bean.student.Student;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> allPageStu(Pager pager);

    int getTotalRow();

    List<Student> allStu();
}