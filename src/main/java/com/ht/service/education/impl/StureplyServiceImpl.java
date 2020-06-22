package com.ht.service.education.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Stureply;
import com.ht.dao.education.StureplyMapper;
import com.ht.service.education.StureplyService;
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
