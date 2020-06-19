package com.ht.dao.education;

import com.ht.bean.education.Classtype;

/**
 * @author 王金宝
 * @date 2020/6/19 19:10
 * 
 */
public interface ClasstypeMapper {
    int deleteByPrimaryKey(Integer classtypeid);

    int insert(Classtype record);

    int insertSelective(Classtype record);

    Classtype selectByPrimaryKey(Integer classtypeid);

    int updateByPrimaryKeySelective(Classtype record);

    int updateByPrimaryKey(Classtype record);
}