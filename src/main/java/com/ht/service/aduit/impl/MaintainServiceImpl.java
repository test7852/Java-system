package com.ht.service.aduit.impl;

import com.ht.bean.emp.Dep;
import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.aduit.Maintain;
import com.ht.dao.aduit.MaintainMapper;
import com.ht.service.aduit.MaintainService;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/19 8:10
 * 
 */
@Service
public class MaintainServiceImpl implements MaintainService{

    @Resource
    private MaintainMapper maintainMapper;

    @Override
    public int deleteByPrimaryKey(Integer wxid) {
        return maintainMapper.deleteByPrimaryKey(wxid);
    }

    @Override
    public int insert(Maintain record) {
        return maintainMapper.insert(record);
    }

    @Override
    public int insertSelective(Maintain record) {
        return maintainMapper.insertSelective(record);
    }

    @Override
    public Maintain selectByPrimaryKey(Integer wxid) {
        return maintainMapper.selectByPrimaryKey(wxid);
    }

    @Override
    public int updateByPrimaryKeySelective(Maintain record) {
        return maintainMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Maintain record) {
        return maintainMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selMain() {
        return maintainMapper.selMain();
    }

    @Override
    public List<Studentclass> selclass() {
        return maintainMapper.selclass();
    }

    @Override
    public List<Dep> seldep() {
        return maintainMapper.seldep();
    }

    @Override  //Integer emp_id,  emp_id
    public List<Map> byidpage(Integer emp_id,Pager pager,Maintain maintain) {
        return maintainMapper.byidpage(emp_id,pager,maintain);
    }

    @Override
    public int byid(Integer emp_id) {
        return maintainMapper.byid(emp_id);
    }

    @Override
    public List<Maintain> mhmain(Pager pager, Maintain maintain) {
        return maintainMapper.mhmain(pager,maintain);
    }

}
