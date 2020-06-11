package com.ht.service.student.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.student.StudentreplyscoreMapper;
import com.ht.bean.student.Studentreplyscore;
import com.ht.service.student.StudentreplyscoreService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
@Service
public class StudentreplyscoreServiceImpl implements StudentreplyscoreService{

    @Resource
    private StudentreplyscoreMapper studentreplyscoreMapper;

    @Override
    public List<Studentreplyscore> allPageStuRecord(Pager pager) {
        return studentreplyscoreMapper.allPageStuRecord(pager);
    }

    @Override
    public int getTotalRow() {
        return studentreplyscoreMapper.getTotalRow();
    }

    @Override
    public int deleteByPrimaryKey(Integer replyid) {
        return studentreplyscoreMapper.deleteByPrimaryKey(replyid);
    }

    @Override
    public int insert(Studentreplyscore record) {
        return studentreplyscoreMapper.insert(record);
    }

    @Override
    public int insertSelective(Studentreplyscore record) {
        return studentreplyscoreMapper.insertSelective(record);
    }

    @Override
    public Studentreplyscore selectByPrimaryKey(Integer replyid) {
        return studentreplyscoreMapper.selectByPrimaryKey(replyid);
    }

    @Override
    public int updateByPrimaryKeySelective(Studentreplyscore record) {
        return studentreplyscoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studentreplyscore record) {
        return studentreplyscoreMapper.updateByPrimaryKey(record);
    }

}
