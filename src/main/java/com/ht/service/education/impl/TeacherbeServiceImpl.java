package com.ht.service.education.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.education.TeacherbeMapper;
import com.ht.bean.education.Teacherbe;
import com.ht.service.education.TeacherbeService;
/**
 * @author lrq
 * @date 2020/6/11 15:44
 * 
 */
@Service
public class TeacherbeServiceImpl implements TeacherbeService{

    @Resource
    private TeacherbeMapper teacherbeMapper;

    @Override
    public int deleteByPrimaryKey(Integer beid) {
        return teacherbeMapper.deleteByPrimaryKey(beid);
    }

    @Override
    public int insert(Teacherbe record) {
        return teacherbeMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacherbe record) {
        return teacherbeMapper.insertSelective(record);
    }

    @Override
    public Teacherbe selectByPrimaryKey(Integer beid) {
        return teacherbeMapper.selectByPrimaryKey(beid);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacherbe record) {
        return teacherbeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacherbe record) {
        return teacherbeMapper.updateByPrimaryKey(record);
    }

}
