package com.ht.dao.emp;

import com.ht.bean.emp.Aduitmodel;

/**
 * @author 王金宝
 * @date 2020/6/16 9:08
 * 
 */
public interface AduitmodelMapper {
    int deleteByPrimaryKey(Integer aduitmodelid);

    int insert(Aduitmodel record);

    int insertSelective(Aduitmodel record);

    Aduitmodel selectByPrimaryKey(Integer aduitmodelid);

    int updateByPrimaryKeySelective(Aduitmodel record);

    int updateByPrimaryKey(Aduitmodel record);
}