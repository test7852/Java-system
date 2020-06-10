package com.ht.dao.student;

import com.ht.bean.student.Studentreplyscore;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
public interface StudentreplyscoreMapper {

    List<Studentreplyscore> allPageStuRecord(Pager pager);//分页查询

    int getTotalRow();//获取总行数

    int deleteByPrimaryKey(Integer replyid);

    int insert(Studentreplyscore record);

    int insertSelective(Studentreplyscore record);

    Studentreplyscore selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Studentreplyscore record);

    int updateByPrimaryKey(Studentreplyscore record);
}