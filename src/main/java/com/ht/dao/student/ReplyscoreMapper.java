package com.ht.dao.student;

import com.ht.bean.student.Replyscore;

/**
 * @author 王金宝
 * @date 2020/6/16 9:06
 * 
 */
public interface ReplyscoreMapper {
    int insert(Replyscore record);

    int insertSelective(Replyscore record);
}