package com.ht.dao.aduit;

import com.ht.bean.aduit.Maintain;

/**
 * @author 王金宝
 * @date 2020/6/19 8:10
 * 
 */
public interface MaintainMapper {
    int deleteByPrimaryKey(Integer wxid);

    int insert(Maintain record);

    int insertSelective(Maintain record);

    Maintain selectByPrimaryKey(Integer wxid);

    int updateByPrimaryKeySelective(Maintain record);

    int updateByPrimaryKey(Maintain record);
}