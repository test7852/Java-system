package com.ht.service.emp.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.emp.DepMapper;
import com.ht.bean.emp.Dep;
import com.ht.service.emp.DepService;
/**
 * @author 王金宝
 * @date 2020/6/8 20:41
 *  
 */
@Service
public class DepServiceImpl implements DepService{

    @Resource
    private DepMapper depMapper;

    @Override
    public int deleteByPrimaryKey(Integer depid) {
        return depMapper.deleteByPrimaryKey(depid);
    }

    @Override
    public int insert(Dep record) {
        return depMapper.insert(record);
    }

    @Override
    public int insertSelective(Dep record) {
        return depMapper.insertSelective(record);
    }

    @Override
    public Dep selectByPrimaryKey(Integer depid) {
        return depMapper.selectByPrimaryKey(depid);
    }

    @Override
    public int updateByPrimaryKeySelective(Dep record) {
        return depMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dep record) {
        return depMapper.updateByPrimaryKey(record);
    }

}
