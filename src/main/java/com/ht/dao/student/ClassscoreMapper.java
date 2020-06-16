package com.ht.dao.student;

import com.ht.bean.student.Classscore;

/**
 * @author 王金宝
 * @date 2020/6/16 9:06
 * 
 */
public interface ClassscoreMapper {
    int insert(Classscore record);

    int insertSelective(Classscore record);
}