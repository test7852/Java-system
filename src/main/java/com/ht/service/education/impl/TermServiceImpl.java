package com.ht.service.education.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.education.TermMapper;
import com.ht.bean.education.Term;
import com.ht.service.education.TermService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
@Service
public class TermServiceImpl implements TermService{

    @Resource
    private TermMapper termMapper;

    @Override
    public List<Term> allTerm() {
        return termMapper.allTerm();
    }

    @Override
    public int deleteByPrimaryKey(Integer termid) {
        return termMapper.deleteByPrimaryKey(termid);
    }

    @Override
    public int insert(Term record) {
        return termMapper.insert(record);
    }

    @Override
    public int insertSelective(Term record) {
        return termMapper.insertSelective(record);
    }

    @Override
    public Term selectByPrimaryKey(Integer termid) {
        return termMapper.selectByPrimaryKey(termid);
    }

    @Override
    public int updateByPrimaryKeySelective(Term record) {
        return termMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Term record) {
        return termMapper.updateByPrimaryKey(record);
    }

}
