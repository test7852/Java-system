package com.ht.dao.education;

import com.ht.bean.education.Term;
import com.ht.bean.student.Dept;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
public interface TermMapper {
    int deleteByPrimaryKey(Integer termid);

    int insert(Term record);

    int insertSelective(Term record);

    Term selectByPrimaryKey(Integer termid);

    int updateByPrimaryKeySelective(Term record);

    int updateByPrimaryKey(Term record);

    /**
     *
     * @return
     * 获取所有学期
     */
    List<Term> allTerm();

    List<Term> Termpaging(Pager pager);

    int gettermRow();//获取总数据量
}