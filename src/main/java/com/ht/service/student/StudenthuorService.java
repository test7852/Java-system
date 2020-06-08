package com.ht.service.student;

import com.ht.bean.student.Studenthuor;
    /**
 * @author 王金宝
 * @date 2020/6/8 20:43
 *  
 */
public interface StudenthuorService{


    int deleteByPrimaryKey(Integer hourid);

    int insert(Studenthuor record);

    int insertSelective(Studenthuor record);

    Studenthuor selectByPrimaryKey(Integer hourid);

    int updateByPrimaryKeySelective(Studenthuor record);

    int updateByPrimaryKey(Studenthuor record);

}
