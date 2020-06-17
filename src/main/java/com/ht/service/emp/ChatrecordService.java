package com.ht.service.emp;

import com.ht.bean.emp.Chatrecord;
import com.ht.bean.student.Student;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/14 10:02
 * 
 */
public interface ChatrecordService{
    int selchatcount();

    List<Chatrecord> allPageChatrecord(Pager pager);

    int deleteByPrimaryKey(Integer chatid);

    int insert(Chatrecord record);

    int insertSelective(Chatrecord record);

    Chatrecord selectByPrimaryKey(Integer chatid);

    List<Chatrecord> selectByChatid(Integer chatid);

    List<Student> selectStudent();

    int updateByPrimaryKeySelective(Chatrecord record);

    int updateByPrimaryKey(Chatrecord record);

}
