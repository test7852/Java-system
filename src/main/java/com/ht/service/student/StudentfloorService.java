package com.ht.service.student;

import com.ht.bean.student.Studentfloor;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
public interface StudentfloorService{
    List<Studentfloor> selList();//查询所有

    List<Studentfloor> sybase(Pager pager);//分页查询

    int selCount();//查询总数

    int deleteByPrimaryKey(Integer floorid);

    int insert(Studentfloor record);

    int insertSelective(Studentfloor record);

    Studentfloor selectByPrimaryKey(Integer floorid);

    int updateByPrimaryKeySelective(Studentfloor record);

    int updateByPrimaryKey(Studentfloor record);

}
