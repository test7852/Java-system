package com.ht.service.education;

import com.ht.bean.education.Classreply;
import com.ht.util.Pager;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/22 8:37
 * 
 */
public interface ClassreplyService{

    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Map> allPageClassReply(Pager pager);

    /**
     * @return
     * 获取总行数
     */
    int getTotalRow();

    /**
     * @return
     * 获取最新的ID
     */
    int getId();

    int deleteByPrimaryKey(Integer replyid);

    int insert(Classreply record);

    int insertSelective(Classreply record);

    Classreply selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Classreply record);

    int updateByPrimaryKey(Classreply record);

}
