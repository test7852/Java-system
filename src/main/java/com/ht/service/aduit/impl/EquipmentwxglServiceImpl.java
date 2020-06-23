package com.ht.service.aduit.impl;

import com.ht.bean.emp.Dep;
import com.ht.bean.student.Dept;
import com.ht.bean.student.Student;
import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.aduit.EquipmentwxglMapper;
import com.ht.bean.aduit.Equipmentwxgl;
import com.ht.service.aduit.EquipmentwxglService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/16 20:43
 * 
 */
@Service
public class EquipmentwxglServiceImpl implements EquipmentwxglService{

    @Resource
    private EquipmentwxglMapper equipmentwxglMapper;

    @Override
    public int deleteByPrimaryKey(Integer wxid) {
        return equipmentwxglMapper.deleteByPrimaryKey(wxid);
    }

    @Override
    public int insert(Equipmentwxgl record) {
        return equipmentwxglMapper.insert(record);
    }

    @Override
    public int insertSelective(Equipmentwxgl record) {
        return equipmentwxglMapper.insertSelective(record);
    }

    @Override
    public Equipmentwxgl selectByPrimaryKey(Integer wxid) {
        return equipmentwxglMapper.selectByPrimaryKey(wxid);
    }

    @Override
    public int updateByPrimaryKeySelective(Equipmentwxgl record) {
        return equipmentwxglMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Equipmentwxgl record) {
        return equipmentwxglMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selEqui() {
        return equipmentwxglMapper.selEqui();
    }

    @Override
    public List<Equipmentwxgl> selByPage(Pager pager) {
        return equipmentwxglMapper.selbypage((pager.currPage-1)*pager.pageSize,pager.pageSize);
    }

    @Override
    public List<Studentclass> selclass() {
        return equipmentwxglMapper.selclass();
    }

    @Override
    public List<Dep> seldep() {
        return equipmentwxglMapper.seldep();
    }

}
