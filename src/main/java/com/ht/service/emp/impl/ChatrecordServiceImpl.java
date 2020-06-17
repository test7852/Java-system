package com.ht.service.emp.impl;

import com.ht.bean.student.Student;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.emp.ChatrecordMapper;
import com.ht.bean.emp.Chatrecord;
import com.ht.service.emp.ChatrecordService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/14 10:02
 * 
 */
@Service
public class ChatrecordServiceImpl implements ChatrecordService{

    @Resource
    private ChatrecordMapper chatrecordMapper;

    @Override
    public int selchatcount() {
        return chatrecordMapper.selchatcount();
    }

    @Override
    public List<Chatrecord> allPageChatrecord(Pager pager) {
        return chatrecordMapper.allPageChatrecord(pager);
    }

    @Override
    public int deleteByPrimaryKey(Integer chatid) {
        return chatrecordMapper.deleteByPrimaryKey(chatid);
    }

    @Override
    public int insert(Chatrecord record) {
        return chatrecordMapper.insert(record);
    }

    @Override
    public int insertSelective(Chatrecord record) {
        return chatrecordMapper.insertSelective(record);
    }

    @Override
    public Chatrecord selectByPrimaryKey(Integer chatid) {
        return chatrecordMapper.selectByPrimaryKey(chatid);
    }

    @Override
    public List<Chatrecord> selectByChatid(Integer chatid) {
        return chatrecordMapper.selectByChatid(chatid);
    }

    @Override
    public List<Student> selectStudent() {
        return chatrecordMapper.selectStudent();
    }

    @Override
    public int updateByPrimaryKeySelective(Chatrecord record) {
        return chatrecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Chatrecord record) {
        return chatrecordMapper.updateByPrimaryKey(record);
    }

}
