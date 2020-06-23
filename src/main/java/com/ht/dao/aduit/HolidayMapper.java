package com.ht.dao.aduit;

import com.ht.bean.aduit.Holiday;
import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/19 19:07
 * 
 */
public interface HolidayMapper {
    List<Studentclass> sybase(@Param("pager") Pager pager,@Param("id") int id);//分页

    int selCount();//查询总数

    int deleteByPrimaryKey(Integer holidayid);

    int insert(Holiday record);

    int insertSelective(Holiday record);

    Holiday selectByPrimaryKey(Integer holidayid);

    int updateByPrimaryKeySelective(Holiday record);

    int updateByPrimaryKey(Holiday record);
}