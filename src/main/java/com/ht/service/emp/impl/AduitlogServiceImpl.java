package com.ht.service.emp.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.emp.Aduitlog;
import com.ht.dao.emp.AduitlogMapper;
import com.ht.service.emp.AduitlogService;
/**
 * @author 王金宝
 * @date 2020/6/16 9:07
 * 
 */
@Service
public class AduitlogServiceImpl implements AduitlogService{

    @Resource
    private AduitlogMapper aduitlogMapper;

    @Override
    public int deleteByPrimaryKey(Integer aduitlogid) {
        return aduitlogMapper.deleteByPrimaryKey(aduitlogid);
    }

    @Override
    public int insert(Aduitlog record) {
        return aduitlogMapper.insert(record);
    }

    @Override
    public int insertSelective(Aduitlog record) {
        return aduitlogMapper.insertSelective(record);
    }

    @Override
    public Aduitlog selectByPrimaryKey(Integer aduitlogid) {
        return aduitlogMapper.selectByPrimaryKey(aduitlogid);
    }

    @Override
    public int updateByPrimaryKeySelective(Aduitlog record) {
        return aduitlogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Aduitlog record) {
        return aduitlogMapper.updateByPrimaryKey(record);
    }

}
