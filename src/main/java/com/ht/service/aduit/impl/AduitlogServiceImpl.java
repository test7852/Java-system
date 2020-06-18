package com.ht.service.aduit.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.aduit.Aduitlog;
import com.ht.dao.aduit.AduitlogMapper;
import com.ht.service.aduit.AduitlogService;

import java.util.List;

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

    @Override
    public int getTotalRow() {
        return aduitlogMapper.getTotalRow();
    }

    @Override
    public List<Aduitlog> allPageAduitlog(Pager pager) {
        return aduitlogMapper.allPageAduitlog(pager);
    }

    @Override
    public List<Aduitlog> allAduitlog() {
        return aduitlogMapper.allAduitlog();
    }

}
