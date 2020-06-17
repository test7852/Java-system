package com.ht.service.student.impl;

import com.ht.bean.student.Studentfloor;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.student.StudenthuorMapper;
import com.ht.bean.student.Studenthuor;
import com.ht.service.student.StudenthuorService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:43
 *  
 */
@Service
public class StudenthuorServiceImpl implements StudenthuorService{

    @Resource
    private StudenthuorMapper studenthuorMapper;


    @Override
    public List<Studenthuor> selList() {
        return studenthuorMapper.selList();
    }

    @Override
    public List<Studenthuor> sybase(Pager pager) {
        return studenthuorMapper.sybase(pager);
    }

    @Override
    public List<Studenthuor> selByFid(Integer floorId) {
        return studenthuorMapper.selByFid(floorId);
    }

    @Override
    public int selCount() {
        return studenthuorMapper.selCount();
    }

    @Override
    public int deleteByPrimaryKey(Integer hourid) {
        return studenthuorMapper.deleteByPrimaryKey(hourid);
    }

    @Override
    public int insert(Studenthuor record) {
        return studenthuorMapper.insert(record);
    }

    @Override
    public int insertSelective(Studenthuor record) {
        return studenthuorMapper.insertSelective(record);
    }

    @Override
    public Studenthuor selectByPrimaryKey(Integer hourid) {
        return studenthuorMapper.selectByPrimaryKey(hourid);
    }

    @Override
    public int updateByPrimaryKeySelective(Studenthuor record) {
        return studenthuorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studenthuor record) {
        return studenthuorMapper.updateByPrimaryKey(record);
    }

}
