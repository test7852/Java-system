package com.ht.dao.emp;

import com.ht.bean.emp.Chatrecord;

/**
 * @author 王金宝
 * @date 2020/6/14 10:02
 * 
 */
public interface ChatrecordMapper {
    int deleteByPrimaryKey(Integer chatid);

    int insert(Chatrecord record);

    int insertSelective(Chatrecord record);

    Chatrecord selectByPrimaryKey(Integer chatid);

    int updateByPrimaryKeySelective(Chatrecord record);

    int updateByPrimaryKey(Chatrecord record);
}