package com.ht.service.student.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.student.StudentScoreMapper;
import com.ht.bean.student.StudentScore;
import com.ht.service.student.StudentScoreService;
/**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
@Service
public class StudentScoreServiceImpl implements StudentScoreService{

    @Resource
    private StudentScoreMapper studentScoreMapper;

    @Override
    public int deleteByPrimaryKey(Integer scoreid) {
        return studentScoreMapper.deleteByPrimaryKey(scoreid);
    }

    @Override
    public int insert(StudentScore record) {
        return studentScoreMapper.insert(record);
    }

    @Override
    public int insertSelective(StudentScore record) {
        return studentScoreMapper.insertSelective(record);
    }

    @Override
    public StudentScore selectByPrimaryKey(Integer scoreid) {
        return studentScoreMapper.selectByPrimaryKey(scoreid);
    }

    @Override
    public int updateByPrimaryKeySelective(StudentScore record) {
        return studentScoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StudentScore record) {
        return studentScoreMapper.updateByPrimaryKey(record);
    }

}
