package com.ht.dao.student;

import com.ht.bean.student.Studentfloor;
import com.ht.bean.student.Studenthuor;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:43
 *  
 */
public interface StudenthuorMapper {
    List<Studenthuor> selList();//查询所有

    List<Studentfloor> sybase(Pager pager);//分页查询

    int selCount();//查询总数

    int deleteByPrimaryKey(Integer hourid);

    int insert(Studenthuor record);

    int insertSelective(Studenthuor record);

    Studenthuor selectByPrimaryKey(Integer hourid);

    int updateByPrimaryKeySelective(Studenthuor record);

    int updateByPrimaryKey(Studenthuor record);
}