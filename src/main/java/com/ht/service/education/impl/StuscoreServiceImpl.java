package com.ht.service.education.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.education.StuscoreMapper;
import com.ht.bean.education.Stuscore;
import com.ht.service.education.StuscoreService;
/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
@Service
public class StuscoreServiceImpl implements StuscoreService{

    @Resource
    private StuscoreMapper stuscoreMapper;

    @Override
    public int deleteByPrimaryKey(Integer ssid) {
        return stuscoreMapper.deleteByPrimaryKey(ssid);
    }

    @Override
    public int insert(Stuscore record) {
        return stuscoreMapper.insert(record);
    }

    @Override
    public int insertSelective(Stuscore record) {
        return stuscoreMapper.insertSelective(record);
    }

    @Override
    public Stuscore selectByPrimaryKey(Integer ssid) {
        return stuscoreMapper.selectByPrimaryKey(ssid);
    }

    @Override
    public int updateByPrimaryKeySelective(Stuscore record) {
        return stuscoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Stuscore record) {
        return stuscoreMapper.updateByPrimaryKey(record);
    }

}
