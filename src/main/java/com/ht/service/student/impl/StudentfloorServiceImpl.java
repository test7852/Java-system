package com.ht.service.student.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.student.Studentfloor;
import com.ht.dao.student.StudentfloorMapper;
import com.ht.service.student.StudentfloorService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
@Service
public class StudentfloorServiceImpl implements StudentfloorService{

    @Resource
    private StudentfloorMapper studentfloorMapper;

    @Override
    public List<Studentfloor> sybase(Pager pager) {
        return studentfloorMapper.sybase(pager);
    }

    @Override
    public int selCount() {
        return studentfloorMapper.selCount();
    }

    @Override
    public int deleteByPrimaryKey(Integer floorid) {
        return studentfloorMapper.deleteByPrimaryKey(floorid);
    }

    @Override
    public int insert(Studentfloor record) {
        return studentfloorMapper.insert(record);
    }

    @Override
    public int insertSelective(Studentfloor record) {
        return studentfloorMapper.insertSelective(record);
    }

    @Override
    public Studentfloor selectByPrimaryKey(Integer floorid) {
        return studentfloorMapper.selectByPrimaryKey(floorid);
    }

    @Override
    public int updateByPrimaryKeySelective(Studentfloor record) {
        return studentfloorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studentfloor record) {
        return studentfloorMapper.updateByPrimaryKey(record);
    }

}
