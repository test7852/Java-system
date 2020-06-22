package com.ht.dao.emp;

import com.ht.bean.emp.Chatrecord;
import com.ht.bean.student.Student;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/14 10:02
 * 
 */
public interface ChatrecordMapper {
    int selchatcount();

    int selchatcountmonth(Integer empid);//查询每个用户每月的谈心记录总数

    List<Chatrecord> allPageChatrecord(Pager pager);

    int deleteByPrimaryKey(Integer chatid);

    int insert(Chatrecord record);

    int insertSelective(Chatrecord record);

    Chatrecord selectByPrimaryKey(Integer chatid);

    List<Chatrecord> selectByChatid(Integer chatid);

    int updateByPrimaryKeySelective(Chatrecord record);

    int updateByPrimaryKey(Chatrecord record);

    List<Student> selectStudent();
}