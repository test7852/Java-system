package com.ht.service.student.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.student.Student;
import com.ht.dao.student.StudentMapper;
import com.ht.service.student.StudentService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer studid) {
        return studentMapper.deleteByPrimaryKey(studid);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer studid) {
        return studentMapper.selectByPrimaryKey(studid);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> allPageStu(Pager pager) {
        return studentMapper.allPageStu(pager);
    }

    @Override
    public int getTotalRow() {
        return studentMapper.getTotalRow();
    }

}
