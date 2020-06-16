package com.ht.service.student;

import com.ht.bean.student.Classscore;
    /**
 * @author 王金宝
 * @date 2020/6/16 9:06
 * 
 */
public interface ClassscoreService{


    int insert(Classscore record);

    int insertSelective(Classscore record);

}
