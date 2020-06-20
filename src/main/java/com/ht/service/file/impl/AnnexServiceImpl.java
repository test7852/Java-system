package com.ht.service.file.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.file.Annex;
import com.ht.dao.file.AnnexMapper;
import com.ht.service.file.AnnexService;

import java.util.List;

/**
 * @author lrq
 * @date 2020/6/19 8:36
 * 
 */
@Service
public class AnnexServiceImpl implements AnnexService{

    @Resource
    private AnnexMapper annexMapper;

    @Override
    public int selCount() {
        return annexMapper.selCount();
    }

    @Override
    public List<Annex> sellist(Pager pager,String sename,Integer seid) {
        return annexMapper.sellist(pager,sename,seid);
    }

    @Override
    public int deleteByPrimaryKey(Integer annexid) {
        return annexMapper.deleteByPrimaryKey(annexid);
    }

    @Override
    public int insert(Annex record) {
        return annexMapper.insert(record);
    }

    @Override
    public int insertSelective(Annex record) {
        return annexMapper.insertSelective(record);
    }

    @Override
    public Annex selectByPrimaryKey(Integer annexid) {
        return annexMapper.selectByPrimaryKey(annexid);
    }

    @Override
    public int updateByPrimaryKeySelective(Annex record) {
        return annexMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Annex record) {
        return annexMapper.updateByPrimaryKey(record);
    }

}
