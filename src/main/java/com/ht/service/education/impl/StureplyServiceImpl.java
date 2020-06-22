package com.ht.service.education.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Stureply;
import com.ht.dao.education.StureplyMapper;
import com.ht.service.education.StureplyService;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
@Service
public class StureplyServiceImpl implements StureplyService{

    @Resource
    private StureplyMapper stureplyMapper;

    @Override
    public int delByStuReply(Integer replyid) {
        return stureplyMapper.delByStuReply(replyid);
    }

    @Override
    public List<Map> allPageClassReply(Pager pager, Integer replyid) {
        return stureplyMapper.allPageClassReply(pager,replyid);
    }

    @Override
    public List<Stureply> allClassReply() {
        return stureplyMapper.allClassReply();
    }

    @Override
    public int getTotalRow(Integer replyid) {
        return stureplyMapper.getTotalRow(replyid);
    }

    @Override
    public int deleteByPrimaryKey(Integer srid) {
        return stureplyMapper.deleteByPrimaryKey(srid);
    }

    @Override
    public int insert(Stureply record) {
        return stureplyMapper.insert(record);
    }

    @Override
    public int insertSelective(Stureply record) {
        return stureplyMapper.insertSelective(record);
    }

    @Override
    public Stureply selectByPrimaryKey(Integer srid) {
        return stureplyMapper.selectByPrimaryKey(srid);
    }

    @Override
    public int updateByPrimaryKeySelective(Stureply record) {
        return stureplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Stureply record) {
        return stureplyMapper.updateByPrimaryKey(record);
    }

}
