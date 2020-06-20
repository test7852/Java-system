package com.ht.service.file;

import com.ht.bean.file.Annex;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author lrq
 * @date 2020/6/19 8:36
 * 
 */
public interface AnnexService{

    int selCount();//查询总数

    List<Annex> sellist(Pager pager,String sename,Integer seid);//分页

    int deleteByPrimaryKey(Integer annexid);

    int insert(Annex record);

    int insertSelective(Annex record);

    Annex selectByPrimaryKey(Integer annexid);

    int updateByPrimaryKeySelective(Annex record);

    int updateByPrimaryKey(Annex record);

}
