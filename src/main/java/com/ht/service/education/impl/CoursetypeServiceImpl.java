package com.ht.service.education.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.education.Coursetype;
import com.ht.dao.education.CoursetypeMapper;
import com.ht.service.education.CoursetypeService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:40
 *  
 */
@Service
public class CoursetypeServiceImpl implements CoursetypeService{

    @Resource
    private CoursetypeMapper coursetypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer coursetypeid) {
        return coursetypeMapper.deleteByPrimaryKey(coursetypeid);
    }

    @Override
    public int insert(Coursetype record) {
        return coursetypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Coursetype record) {
        return coursetypeMapper.insertSelective(record);
    }

    @Override
    public Coursetype selectByPrimaryKey(Integer coursetypeid) {
        return coursetypeMapper.selectByPrimaryKey(coursetypeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Coursetype record) {
        return coursetypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Coursetype record) {
        return coursetypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selCountEdu() {
        return coursetypeMapper.selCountEdu();
    }

    @Override
    public List<Coursetype> selByPage(Pager pager) {
        return coursetypeMapper.selbypage((pager.currPage-1)*pager.pageSize,pager.pageSize);
    }

    @Override
    public Coursetype selName(String coursetypename) {
        return coursetypeMapper.selName(coursetypename);
    }

}
