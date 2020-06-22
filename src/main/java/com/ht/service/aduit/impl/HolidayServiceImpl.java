package com.ht.service.aduit.impl;

import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.aduit.HolidayMapper;
import com.ht.bean.aduit.Holiday;
import com.ht.service.aduit.HolidayService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/19 19:07
 * 
 */
@Service
public class HolidayServiceImpl implements HolidayService{

    @Resource
    private HolidayMapper holidayMapper;

    @Override
    public List<Studentclass> sybase(Pager pager,int id) {
        return holidayMapper.sybase(pager,id);
    }

    @Override
    public int selCount() {
        return holidayMapper.selCount();
    }

    @Override
    public int deleteByPrimaryKey(Integer holidayid) {
        return holidayMapper.deleteByPrimaryKey(holidayid);
    }

    @Override
    public int insert(Holiday record) {
        return holidayMapper.insert(record);
    }

    @Override
    public int insertSelective(Holiday record) {
        return holidayMapper.insertSelective(record);
    }

    @Override
    public Holiday selectByPrimaryKey(Integer holidayid) {
        return holidayMapper.selectByPrimaryKey(holidayid);
    }

    @Override
    public int updateByPrimaryKeySelective(Holiday record) {
        return holidayMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Holiday record) {
        return holidayMapper.updateByPrimaryKey(record);
    }

}
