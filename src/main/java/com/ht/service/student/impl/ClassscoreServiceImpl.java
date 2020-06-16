package com.ht.service.student.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.student.ClassscoreMapper;
import com.ht.bean.student.Classscore;
import com.ht.service.student.ClassscoreService;
/**
 * @author 王金宝
 * @date 2020/6/16 9:06
 * 
 */
@Service
public class ClassscoreServiceImpl implements ClassscoreService{

    @Resource
    private ClassscoreMapper classscoreMapper;

    @Override
    public int insert(Classscore record) {
        return classscoreMapper.insert(record);
    }

    @Override
    public int insertSelective(Classscore record) {
        return classscoreMapper.insertSelective(record);
    }

}
