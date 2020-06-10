package com.ht.dao.student;

import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/10 10:47
 * 
 */
public interface StudentclassMapper {
    int selCount();//查询总数

    List<Studentclass> sybase(Pager pager);//分页

    int deleteByPrimaryKey(Integer classid);

    int insert(Studentclass record);

    int insertSelective(Studentclass record);

    Studentclass selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Studentclass record);

    int updateByPrimaryKey(Studentclass record);
}