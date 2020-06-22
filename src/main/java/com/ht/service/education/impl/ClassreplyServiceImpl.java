package com.ht.service.education.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Classreply;
import com.ht.dao.education.ClassreplyMapper;
import com.ht.service.education.ClassreplyService;

import java.util.List;
import java.util.Map;

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
    public List<Map> allPageClassReply(Pager pager) {
        return classreplyMapper.allPageClassReply(pager);
    }

    @Override
    public int getTotalRow() {
        return classreplyMapper.getTotalRow();
    }

    @Override
    public int getId() {
        return classreplyMapper.getId();
    }

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
