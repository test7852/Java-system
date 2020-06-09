package com.ht.service.education.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Course;
import com.ht.dao.education.CourseMapper;
import com.ht.service.education.CourseService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:35
 *  
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Resource
    private CourseMapper courseMapper;

    @Override
    public int deleteByPrimaryKey(Integer courseid) {
        return courseMapper.deleteByPrimaryKey(courseid);
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(Integer courseid) {
        return courseMapper.selectByPrimaryKey(courseid);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selCountcEdu() {
        return courseMapper.selCountcEdu();
    }

    @Override
    public List<Course> selByPage(Pager pager) {
        return courseMapper.selbypage((pager.currPage-1)*pager.pageSize,pager.pageSize);
    }

}
