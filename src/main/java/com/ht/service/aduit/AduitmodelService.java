package com.ht.service.aduit;

import com.ht.bean.aduit.Aduitmodel;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/16 9:08
 * 
 */
public interface AduitmodelService{

    /**
     * @return
     * 查询总数
     */
    int getTotalRow();

    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Aduitmodel> allPageAduitmodel(Pager pager);
    /**
     * @return
     * 获取所有考核指标
     */
    List<Aduitmodel> allAduitmodel();


    int deleteByPrimaryKey(Integer aduitmodelid);

    int insert(Aduitmodel record);

    int insertSelective(Aduitmodel record);

    Aduitmodel selectByPrimaryKey(Integer aduitmodelid);

    int updateByPrimaryKeySelective(Aduitmodel record);

    int updateByPrimaryKey(Aduitmodel record);

}
