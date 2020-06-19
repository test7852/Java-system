package com.ht.service.education;

import com.ht.bean.education.Term;
    /**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
public interface TermService{


    int deleteByPrimaryKey(Integer termid);

    int insert(Term record);

    int insertSelective(Term record);

    Term selectByPrimaryKey(Integer termid);

    int updateByPrimaryKeySelective(Term record);

    int updateByPrimaryKey(Term record);

}
