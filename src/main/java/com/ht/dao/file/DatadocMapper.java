package com.ht.dao.file;

import com.ht.bean.file.Datadoc;

/**
 * @author 王金宝
 * @date 2020/6/11 8:43
 * 
 */
public interface DatadocMapper {
    int deleteByPrimaryKey(Integer docid);

    int insert(Datadoc record);

    int insertSelective(Datadoc record);

    Datadoc selectByPrimaryKey(Integer docid);

    int updateByPrimaryKeySelective(Datadoc record);

    int updateByPrimaryKey(Datadoc record);
}