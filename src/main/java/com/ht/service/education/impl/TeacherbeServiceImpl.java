package com.ht.service.education.impl;

import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.education.TeacherbeMapper;
import com.ht.bean.education.Teacherbe;
import com.ht.service.education.TeacherbeService;

import java.util.List;

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

    @Override
    public int selTea() {
        return teacherbeMapper.selTeahcerbe();
    }

    @Override
    public List<Teacherbe> selByPage(Pager pager) {
        return teacherbeMapper.selbypage((pager.currPage-1)*pager.pageSize,pager.pageSize);
    }

    @Override
    public List<Empinfo> listEmp() {
        return teacherbeMapper.selEmplist();
    }

}
