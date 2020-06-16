package com.ht.service.student.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.student.Major;
import com.ht.dao.student.MajorMapper;
import com.ht.service.student.MajorService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/15 20:29
 * 
 */
@Service
public class MajorServiceImpl implements MajorService{

    @Resource
    private MajorMapper majorMapper;

    @Override
    public List<Major> selList() {
        return majorMapper.selList();
    }

    @Override
    public int selCount() {
        return majorMapper.selCount();
    }

    @Override
    public List<Major> sybase(Pager pager) {
        return majorMapper.sybase(pager);
    }

    @Override
    public Major selectByName(String majorname) {
        return majorMapper.selectByName(majorname);
    }

    @Override
    public int deleteByPrimaryKey(Integer majorid) {
        return majorMapper.deleteByPrimaryKey(majorid);
    }

    @Override
    public int insert(Major record) {
        return majorMapper.insert(record);
    }

    @Override
    public int insertSelective(Major record) {
        return majorMapper.insertSelective(record);
    }

    @Override
    public Major selectByPrimaryKey(Integer majorid) {
        return majorMapper.selectByPrimaryKey(majorid);
    }

    @Override
    public int updateByPrimaryKeySelective(Major record) {
        return majorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Major record) {
        return majorMapper.updateByPrimaryKey(record);
    }

}
