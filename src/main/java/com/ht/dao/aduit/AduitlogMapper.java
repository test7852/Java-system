package com.ht.dao.aduit;

import com.ht.bean.aduit.Aduitlog;

/**
 * @author 王金宝
 * @date 2020/6/16 9:07
 * 
 */
public interface AduitlogMapper {
    int deleteByPrimaryKey(Integer aduitlogid);

    int insert(Aduitlog record);

    int insertSelective(Aduitlog record);

    Aduitlog selectByPrimaryKey(Integer aduitlogid);

    int updateByPrimaryKeySelective(Aduitlog record);

    int updateByPrimaryKey(Aduitlog record);
}