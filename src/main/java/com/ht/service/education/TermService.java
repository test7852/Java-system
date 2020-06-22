package com.ht.service.education;

import com.ht.bean.education.Term;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
public interface TermService{

    /**
     *
     * @return
     * 获取所有学期
     */
    List<Term> allTerm();

    List<Term> Termpaging(Pager pager);

    int gettermRow();

    int deleteByPrimaryKey(Integer termid);

    int insert(Term record);

    int insertSelective(Term record);

    Term selectByPrimaryKey(Integer termid);

    int updateByPrimaryKeySelective(Term record);

    int updateByPrimaryKey(Term record);

}
