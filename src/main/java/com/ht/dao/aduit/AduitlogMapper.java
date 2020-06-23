package com.ht.dao.aduit;

import com.ht.bean.aduit.Aduitlog;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/16 9:07
 * 
 */
public interface AduitlogMapper {
    int deleteByPrimaryKey(Integer aduitlogid);

    int insert(Aduitlog record);

    int insertSelective(Aduitlog record);

    Aduitlog selectByPrimaryKey(Integer aduitlogid);

    int updateByPrimaryKeySelective(Aduitlog record);

    int updateByPrimaryKey(Aduitlog record);

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
    List<Aduitlog> allPageAduitlog(Pager pager);

    /**
     * @return
     * 获取所有考核入录
     */
    List<Aduitlog> allAduitlog();
}