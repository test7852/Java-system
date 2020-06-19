package com.ht.service.aduit.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.aduit.Maintain;
import com.ht.dao.aduit.MaintainMapper;
import com.ht.service.aduit.MaintainService;
/**
 * @author 王金宝
 * @date 2020/6/19 8:10
 * 
 */
@Service
public class MaintainServiceImpl implements MaintainService{

    @Resource
    private MaintainMapper maintainMapper;

    @Override
    public int deleteByPrimaryKey(Integer wxid) {
        return maintainMapper.deleteByPrimaryKey(wxid);
    }

    @Override
    public int insert(Maintain record) {
        return maintainMapper.insert(record);
    }

    @Override
    public int insertSelective(Maintain record) {
        return maintainMapper.insertSelective(record);
    }

    @Override
    public Maintain selectByPrimaryKey(Integer wxid) {
        return maintainMapper.selectByPrimaryKey(wxid);
    }

    @Override
    public int updateByPrimaryKeySelective(Maintain record) {
        return maintainMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Maintain record) {
        return maintainMapper.updateByPrimaryKey(record);
    }

}
