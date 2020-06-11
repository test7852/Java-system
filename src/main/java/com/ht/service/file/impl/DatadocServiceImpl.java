package com.ht.service.file.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.file.Datadoc;
import com.ht.dao.file.DatadocMapper;
import com.ht.service.file.DatadocService;
/**
 * @author 王金宝
 * @date 2020/6/11 8:43
 * 
 */
@Service
public class DatadocServiceImpl implements DatadocService{

    @Resource
    private DatadocMapper datadocMapper;

    @Override
    public int deleteByPrimaryKey(Integer docid) {
        return datadocMapper.deleteByPrimaryKey(docid);
    }

    @Override
    public int insert(Datadoc record) {
        return datadocMapper.insert(record);
    }

    @Override
    public int insertSelective(Datadoc record) {
        return datadocMapper.insertSelective(record);
    }

    @Override
    public Datadoc selectByPrimaryKey(Integer docid) {
        return datadocMapper.selectByPrimaryKey(docid);
    }

    @Override
    public int updateByPrimaryKeySelective(Datadoc record) {
        return datadocMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Datadoc record) {
        return datadocMapper.updateByPrimaryKey(record);
    }

}
