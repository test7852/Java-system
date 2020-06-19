package com.ht.service.education;

import com.ht.bean.education.Classscore;
    /**
 * @author 王金宝
 * @date 2020/6/19 19:09
 * 
 */
public interface ClassscoreService{


    int deleteByPrimaryKey(Integer cscoreid);

    int insert(Classscore record);

    int insertSelective(Classscore record);

    Classscore selectByPrimaryKey(Integer cscoreid);

    int updateByPrimaryKeySelective(Classscore record);

    int updateByPrimaryKey(Classscore record);

}
