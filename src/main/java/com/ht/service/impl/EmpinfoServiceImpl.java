package com.ht.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.EmpinfoMapper;
import com.ht.bean.Empinfo;
import com.ht.service.EmpinfoService;
/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
@Service
public class EmpinfoServiceImpl implements EmpinfoService{

    @Resource
    private EmpinfoMapper empinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer empId) {
        return empinfoMapper.deleteByPrimaryKey(empId);
    }

    @Override
    public int insert(Empinfo record) {
        return empinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Empinfo record) {
        return empinfoMapper.insertSelective(record);
    }

    @Override
    public Empinfo selectByPrimaryKey(Integer empId) {
        return empinfoMapper.selectByPrimaryKey(empId);
    }

    @Override
    public int updateByPrimaryKeySelective(Empinfo record) {
        return empinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Empinfo record) {
        return empinfoMapper.updateByPrimaryKey(record);
    }

}
