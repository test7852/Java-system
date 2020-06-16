package com.ht.service.emp;

import com.ht.bean.emp.Aduitlog;
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
