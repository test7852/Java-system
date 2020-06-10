package com.ht.service.student;

import com.ht.bean.student.StudentScore;
    /**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
public interface StudentScoreService{


    int deleteByPrimaryKey(Integer scoreid);

    int insert(StudentScore record);

    int insertSelective(StudentScore record);

    StudentScore selectByPrimaryKey(Integer scoreid);

    int updateByPrimaryKeySelective(StudentScore record);

    int updateByPrimaryKey(StudentScore record);

}
