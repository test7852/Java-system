package com.ht.service.emp.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.emp.WorkdiaryMapper;
import com.ht.bean.emp.Workdiary;
import com.ht.service.emp.WorkdiaryService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/12 20:30
 * 
 */
@Service
public class WorkdiaryServiceImpl implements WorkdiaryService{

    @Resource
    private WorkdiaryMapper workdiaryMapper;

    @Override
    public int selworkcount() {
        return workdiaryMapper.selworkcount();
    }

    @Override
    public List<Workdiary> allPageWorkdiary(Pager pager) {
        return workdiaryMapper.allPageWorkdiary(pager);
    }

    @Override
    public int deleteByPrimaryKey(Integer worklogid) {
        return workdiaryMapper.deleteByPrimaryKey(worklogid);
    }

    @Override
    public int insert(Workdiary record) {
        return workdiaryMapper.insert(record);
    }

    @Override
    public int insertSelective(Workdiary record) {
        return workdiaryMapper.insertSelective(record);
    }

    @Override
    public Workdiary selectByPrimaryKey(Integer worklogid) {
        return workdiaryMapper.selectByPrimaryKey(worklogid);
    }

    @Override
    public int updateByPrimaryKeySelective(Workdiary record) {
        return workdiaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Workdiary record) {
        return workdiaryMapper.updateByPrimaryKey(record);
    }

}
