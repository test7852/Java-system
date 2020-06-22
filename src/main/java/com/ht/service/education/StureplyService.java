package com.ht.service.education;

import com.ht.bean.education.Stureply;
    /**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
public interface StureplyService{


    int deleteByPrimaryKey(Integer srid);

    int insert(Stureply record);

    int insertSelective(Stureply record);

    Stureply selectByPrimaryKey(Integer srid);

    int updateByPrimaryKeySelective(Stureply record);

    int updateByPrimaryKey(Stureply record);

}
