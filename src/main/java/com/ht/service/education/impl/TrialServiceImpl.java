package com.ht.service.education.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Trial;
import com.ht.dao.education.TrialMapper;
import com.ht.service.education.TrialService;
/**
 * @author 王金宝
 * @date 2020/6/12 10:36
 * 
 */
@Service
public class TrialServiceImpl implements TrialService{

    @Resource
    private TrialMapper trialMapper;

    @Override
    public int deleteByPrimaryKey(Integer trialid) {
        return trialMapper.deleteByPrimaryKey(trialid);
    }

    @Override
    public int insert(Trial record) {
        return trialMapper.insert(record);
    }

    @Override
    public int insertSelective(Trial record) {
        return trialMapper.insertSelective(record);
    }

    @Override
    public Trial selectByPrimaryKey(Integer trialid) {
        return trialMapper.selectByPrimaryKey(trialid);
    }

    @Override
    public int updateByPrimaryKeySelective(Trial record) {
        return trialMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Trial record) {
        return trialMapper.updateByPrimaryKey(record);
    }

}
