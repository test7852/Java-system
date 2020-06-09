package com.ht.dao.student;

import com.ht.bean.student.Studentfloor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
public interface StudentfloorMapper {

    List<Studentfloor> selsfbypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);//分页查询

    int selsf();//查询总数

    int deleteByPrimaryKey(Integer floorid);

    int insert(Studentfloor record);

    int insertSelective(Studentfloor record);

    Studentfloor selectByPrimaryKey(Integer floorid);

    int updateByPrimaryKeySelective(Studentfloor record);

    int updateByPrimaryKey(Studentfloor record);
}