package com.ht.service.student.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.student.Studentfall;
import com.ht.dao.student.StudentfallMapper;
import com.ht.service.student.StudentfallService;
/**
 * @author 王金宝
 * @date 2020/6/15 16:02
 * 
 */
@Service
public class StudentfallServiceImpl implements StudentfallService{

    @Resource
    private StudentfallMapper studentfallMapper;

    @Override
    public int deleteByPrimaryKey(Integer fallid) {
        return studentfallMapper.deleteByPrimaryKey(fallid);
    }

    @Override
    public int insert(Studentfall record) {
        return studentfallMapper.insert(record);
    }

    @Override
    public int insertSelective(Studentfall record) {
        return studentfallMapper.insertSelective(record);
    }

    @Override
    public Studentfall selectByPrimaryKey(Integer fallid) {
        return studentfallMapper.selectByPrimaryKey(fallid);
    }

    @Override
    public int updateByPrimaryKeySelective(Studentfall record) {
        return studentfallMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studentfall record) {
        return studentfallMapper.updateByPrimaryKey(record);
    }

}
