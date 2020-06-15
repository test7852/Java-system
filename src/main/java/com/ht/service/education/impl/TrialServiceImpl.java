package com.ht.service.education.impl;

import com.ht.bean.education.Course;
import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Trial;
import com.ht.dao.education.TrialMapper;
import com.ht.service.education.TrialService;

import java.util.List;
import java.util.Map;

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

    @Override
    public int selTrial() {
        return trialMapper.selTroal();
    }

    @Override
    public List<Map> selByPage(Pager pager) {
        return trialMapper.selbypage((pager.currPage-1)*pager.pageSize,pager.pageSize);
    }

    @Override
    public List<Course> Coulist() {
        return trialMapper.selCou();
    }

    @Override
    public List<Empinfo> Emplist() {
        return trialMapper.selEmp();
    }

}
