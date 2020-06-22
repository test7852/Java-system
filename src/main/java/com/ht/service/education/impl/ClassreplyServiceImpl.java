package com.ht.service.education.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Classreply;
import com.ht.dao.education.ClassreplyMapper;
import com.ht.service.education.ClassreplyService;
/**
 * @author 王金宝
 * @date 2020/6/22 8:37
 * 
 */
@Service
public class ClassreplyServiceImpl implements ClassreplyService{

    @Resource
    private ClassreplyMapper classreplyMapper;

    @Override
    public int deleteByPrimaryKey(Integer replyid) {
        return classreplyMapper.deleteByPrimaryKey(replyid);
    }

    @Override
    public int insert(Classreply record) {
        return classreplyMapper.insert(record);
    }

    @Override
    public int insertSelective(Classreply record) {
        return classreplyMapper.insertSelective(record);
    }

    @Override
    public Classreply selectByPrimaryKey(Integer replyid) {
        return classreplyMapper.selectByPrimaryKey(replyid);
    }

    @Override
    public int updateByPrimaryKeySelective(Classreply record) {
        return classreplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classreply record) {
        return classreplyMapper.updateByPrimaryKey(record);
    }

}
