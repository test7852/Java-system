package com.ht.service.student.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.student.DeptMapper;
import com.ht.bean.student.Dept;
import com.ht.service.student.DeptService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/15 16:00
 * 
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Resource
    private DeptMapper deptMapper;

    @Override
    public int getTotalRow() {
        return deptMapper.getTotalRow();
    }

    @Override
    public List<Dept> allPageDept(Pager pager) {
        return deptMapper.allPageDept(pager);
    }

    @Override
    public Dept selectByName(String deptName) {
        return deptMapper.selectByName(deptName);
    }

    @Override
    public int deleteByPrimaryKey(Integer deptid) {
        return deptMapper.deleteByPrimaryKey(deptid);
    }

    @Override
    public int insert(Dept record) {
        return deptMapper.insert(record);
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper.insertSelective(record);
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptid) {
        return deptMapper.selectByPrimaryKey(deptid);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptMapper.updateByPrimaryKey(record);
    }

}
