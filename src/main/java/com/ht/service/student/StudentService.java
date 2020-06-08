package com.ht.service.student;

import com.ht.bean.student.Student;
    /**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
public interface StudentService{


    int deleteByPrimaryKey(Integer studid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
