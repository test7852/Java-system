package com.ht.service.student;

import com.ht.bean.student.Studentreplyscore;
    /**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
public interface StudentreplyscoreService{


    int deleteByPrimaryKey(Integer replyid);

    int insert(Studentreplyscore record);

    int insertSelective(Studentreplyscore record);

    Studentreplyscore selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Studentreplyscore record);

    int updateByPrimaryKey(Studentreplyscore record);

}
