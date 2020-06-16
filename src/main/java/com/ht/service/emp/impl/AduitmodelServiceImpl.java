package com.ht.service.emp.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.emp.AduitmodelMapper;
import com.ht.bean.emp.Aduitmodel;
import com.ht.service.emp.AduitmodelService;
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
