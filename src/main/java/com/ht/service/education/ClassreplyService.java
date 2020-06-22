package com.ht.service.education;

import com.ht.bean.education.Classreply;
    /**
 * @author 王金宝
 * @date 2020/6/22 8:37
 * 
 */
public interface ClassreplyService{


    int deleteByPrimaryKey(Integer replyid);

    int insert(Classreply record);

    int insertSelective(Classreply record);

    Classreply selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Classreply record);

    int updateByPrimaryKey(Classreply record);

}
