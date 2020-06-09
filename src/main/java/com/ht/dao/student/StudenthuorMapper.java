package com.ht.dao.student;

import com.ht.bean.student.Studenthuor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:43
 *  
 */
public interface StudenthuorMapper {

    List<Studenthuor> selstbypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);//分页查询

    int selst();//查询总数

    int deleteByPrimaryKey(Integer hourid);

    int insert(Studenthuor record);

    int insertSelective(Studenthuor record);

    Studenthuor selectByPrimaryKey(Integer hourid);

    int updateByPrimaryKeySelective(Studenthuor record);

    int updateByPrimaryKey(Studenthuor record);
}