package com.ht.dao.education;

import com.ht.bean.education.Trial;

/**
 * @author 王金宝
 * @date 2020/6/12 10:36
 * 
 */
public interface TrialMapper {
    int deleteByPrimaryKey(Integer trialid);

    int insert(Trial record);

    int insertSelective(Trial record);

    Trial selectByPrimaryKey(Integer trialid);

    int updateByPrimaryKeySelective(Trial record);

    int updateByPrimaryKey(Trial record);
}