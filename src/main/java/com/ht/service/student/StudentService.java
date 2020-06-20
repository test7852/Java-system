package com.ht.service.student;

import com.ht.bean.student.Student;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
public interface StudentService{


    int deleteByPrimaryKey(Integer studid); //根据id删除学生

    int insert(Student record); //添加学生

    int insertSelective(Student record); //添加部分学生信息

    Student selectByPrimaryKey(Integer studid); //根据id查找学生信息

    int updateByPrimaryKeySelective(Student record); //更新部分学生信息

    int updateByPrimaryKey(Student record); //更新学生信息

    List<Student> allPageStu(Pager pager); //分页查询学生

    int getTotalRow();  //获取总行数

    List<Student> allStu();

    List<Student> allStuClazz(Integer clazz);//根据班级查找学生
}
