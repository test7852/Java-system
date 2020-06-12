package com.ht.service.file;

import com.ht.bean.file.Datadoc;
import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/11 8:43
 * 
 */
public interface DatadocService{

    int selCount();//查询总数

    List<Datadoc> sybase(Pager pager);//分页

    int deleteByPrimaryKey(Integer docid);

    int insert(Datadoc record);

    int insertSelective(Datadoc record);

    Datadoc selectByPrimaryKey(Integer docid);

    int updateByPrimaryKeySelective(Datadoc record);

    int updateByPrimaryKey(Datadoc record);

}
