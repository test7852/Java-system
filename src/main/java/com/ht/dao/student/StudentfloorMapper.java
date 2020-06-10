package com.ht.dao.student;

import com.ht.bean.student.Studentclass;
import com.ht.bean.student.Studentfloor;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
public interface StudentfloorMapper {
    int selCount();//查询总数

    List<Studentfloor> sybase(Pager pager);//分页

    int deleteByPrimaryKey(Integer floorid);

    int insert(Studentfloor record);

    int insertSelective(Studentfloor record);

    Studentfloor selectByPrimaryKey(Integer floorid);

    int updateByPrimaryKeySelective(Studentfloor record);

    int updateByPrimaryKey(Studentfloor record);
}