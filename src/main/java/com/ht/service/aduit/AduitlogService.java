package com.ht.service.aduit;

import com.ht.bean.aduit.Aduitlog;
    /**
 * @author 王金宝
 * @date 2020/6/16 9:07
 * 
 */
public interface AduitlogService{


    int deleteByPrimaryKey(Integer aduitlogid);

    int insert(Aduitlog record);

    int insertSelective(Aduitlog record);

    Aduitlog selectByPrimaryKey(Integer aduitlogid);

    int updateByPrimaryKeySelective(Aduitlog record);

    int updateByPrimaryKey(Aduitlog record);

}
