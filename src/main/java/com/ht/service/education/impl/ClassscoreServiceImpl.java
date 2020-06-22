package com.ht.service.education.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Classscore;
import com.ht.dao.education.ClassscoreMapper;
import com.ht.service.education.ClassscoreService;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/19 19:09
 * 
 */
@Service
public class ClassscoreServiceImpl implements ClassscoreService{

    @Resource
    private ClassscoreMapper classscoreMapper;

    @Override
    public List<Map> allPageClassScore(Pager pager) {
        return classscoreMapper.allPageClassScore(pager);
    }

    @Override
    public int getTotalRow() {
        return classscoreMapper.getTotalRow();
    }

    @Override
    public int getId() {
        return classscoreMapper.getId();
    }

    @Override
    public int deleteByPrimaryKey(Integer cscoreid) {
        return classscoreMapper.deleteByPrimaryKey(cscoreid);
    }

    @Override
    public int insert(Classscore record) {
        return classscoreMapper.insert(record);
    }

    @Override
    public int insertSelective(Classscore record) {
        return classscoreMapper.insertSelective(record);
    }

    @Override
    public Classscore selectByPrimaryKey(Integer cscoreid) {
        return classscoreMapper.selectByPrimaryKey(cscoreid);
    }

    @Override
    public int updateByPrimaryKeySelective(Classscore record) {
        return classscoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classscore record) {
        return classscoreMapper.updateByPrimaryKey(record);
    }

}
