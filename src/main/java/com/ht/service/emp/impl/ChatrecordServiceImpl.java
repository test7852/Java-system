package com.ht.service.emp.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.emp.ChatrecordMapper;
import com.ht.bean.emp.Chatrecord;
import com.ht.service.emp.ChatrecordService;
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
    public int updateByPrimaryKeySelective(Chatrecord record) {
        return chatrecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Chatrecord record) {
        return chatrecordMapper.updateByPrimaryKey(record);
    }

}
