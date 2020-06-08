package com.ht.service.emp.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.emp.EmpinfoMapper;
import com.ht.bean.emp.Empinfo;
import com.ht.service.emp.EmpinfoService;
/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
@Service
public class EmpinfoServiceImpl implements EmpinfoService{

    @Resource
    private EmpinfoMapper empinfoMapper;

    @Override
    public Empinfo login(Empinfo empinfo) {
        return empinfoMapper.login(empinfo);
    }

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
