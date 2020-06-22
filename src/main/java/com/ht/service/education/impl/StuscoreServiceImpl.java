package com.ht.service.education.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.education.StuscoreMapper;
import com.ht.bean.education.Stuscore;
import com.ht.service.education.StuscoreService;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
@Service
public class StuscoreServiceImpl implements StuscoreService{

    @Resource
    private StuscoreMapper stuscoreMapper;

    @Override
    public int delByScoreid(Integer scoreid) {
        return stuscoreMapper.delByScoreid(scoreid);
    }

    @Override
    public List<Map> allPageClassScore(Pager pager,int scoreid) {
        return stuscoreMapper.allPageClassScore(pager,scoreid);
    }

    @Override
    public List<Stuscore> allClassScore() {
        return stuscoreMapper.allClassScore();
    }

    @Override
    public int getTotalRow(Integer scoreid) {
        return stuscoreMapper.getTotalRow(scoreid);
    }

    @Override
    public int deleteByPrimaryKey(Integer ssid) {
        return stuscoreMapper.deleteByPrimaryKey(ssid);
    }

    @Override
    public int insert(Stuscore record) {
        return stuscoreMapper.insert(record);
    }

    @Override
    public int insertSelective(Stuscore record) {
        return stuscoreMapper.insertSelective(record);
    }

    @Override
    public Stuscore selectByPrimaryKey(Integer ssid) {
        return stuscoreMapper.selectByPrimaryKey(ssid);
    }

    @Override
    public int updateByPrimaryKeySelective(Stuscore record) {
        return stuscoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Stuscore record) {
        return stuscoreMapper.updateByPrimaryKey(record);
    }

}
