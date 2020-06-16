package com.ht.service.student.impl;

import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.student.StudentclassMapper;
import com.ht.bean.student.Studentclass;
import com.ht.service.student.StudentclassService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/10 10:47
 * 
 */
@Service
public class StudentclassServiceImpl implements StudentclassService{

    @Resource
    private StudentclassMapper studentclassMapper;

    @Override
    public List<Studentclass> selList() {
        return studentclassMapper.selList();
    }

    @Override
    public int selCount() {
        return studentclassMapper.selCount();
    }

    @Override
    public List<Studentclass> sybase(Pager pager) {
        return studentclassMapper.sybase(pager);
    }

    @Override
    public int deleteByPrimaryKey(Integer classid) {
        return studentclassMapper.deleteByPrimaryKey(classid);
    }

    @Override
    public int insert(Studentclass record) {
        return studentclassMapper.insert(record);
    }

    @Override
    public int insertSelective(Studentclass record) {
        return studentclassMapper.insertSelective(record);
    }

    @Override
    public Studentclass selectByPrimaryKey(Integer classid) {
        return studentclassMapper.selectByPrimaryKey(classid);
    }

    @Override
    public int updateByPrimaryKeySelective(Studentclass record) {
        return studentclassMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studentclass record) {
        return studentclassMapper.updateByPrimaryKey(record);
    }

}
