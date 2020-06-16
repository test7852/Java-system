package com.ht.service.student.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.student.ReplyscoreMapper;
import com.ht.bean.student.Replyscore;
import com.ht.service.student.ReplyscoreService;
/**
 * @author 王金宝
 * @date 2020/6/16 9:06
 * 
 */
@Service
public class ReplyscoreServiceImpl implements ReplyscoreService{

    @Resource
    private ReplyscoreMapper replyscoreMapper;

    @Override
    public int insert(Replyscore record) {
        return replyscoreMapper.insert(record);
    }

    @Override
    public int insertSelective(Replyscore record) {
        return replyscoreMapper.insertSelective(record);
    }

}
