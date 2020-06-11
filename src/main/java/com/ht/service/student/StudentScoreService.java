package com.ht.service.student;

import com.ht.bean.student.StudentScore;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
public interface StudentScoreService{

    List<StudentScore> allPageStuScore(Pager pager);//分页查询

    int getTotalRow();//获取总行数

    int deleteByPrimaryKey(Integer scoreid);

    int insert(StudentScore record);

    int insertSelective(StudentScore record);

    StudentScore selectByPrimaryKey(Integer scoreid);

    int updateByPrimaryKeySelective(StudentScore record);

    int updateByPrimaryKey(StudentScore record);

}
