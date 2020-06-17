package com.ht.service.aduit.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.aduit.AduitmodelMapper;
import com.ht.bean.aduit.Aduitmodel;
import com.ht.service.aduit.AduitmodelService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/16 9:08
 * 
 */
@Service
public class AduitmodelServiceImpl implements AduitmodelService{

    @Resource
    private AduitmodelMapper aduitmodelMapper;

    @Override
    public int getTotalRow() {
        return aduitmodelMapper.getTotalRow();
    }

    @Override
    public List<Aduitmodel> allPageAduitmodel(Pager pager) {
        return aduitmodelMapper.allPageAduitmodel(pager);
    }

    @Override
    public List<Aduitmodel> allAduitmodel() {
        return aduitmodelMapper.allAduitmodel();
    }

    @Override
    public int deleteByPrimaryKey(Integer aduitmodelid) {
        return aduitmodelMapper.deleteByPrimaryKey(aduitmodelid);
    }

    @Override
    public int insert(Aduitmodel record) {
        return aduitmodelMapper.insert(record);
    }

    @Override
    public int insertSelective(Aduitmodel record) {
        return aduitmodelMapper.insertSelective(record);
    }

    @Override
    public Aduitmodel selectByPrimaryKey(Integer aduitmodelid) {
        return aduitmodelMapper.selectByPrimaryKey(aduitmodelid);
    }

    @Override
    public int updateByPrimaryKeySelective(Aduitmodel record) {
        return aduitmodelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Aduitmodel record) {
        return aduitmodelMapper.updateByPrimaryKey(record);
    }

}
