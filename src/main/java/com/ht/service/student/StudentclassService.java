package com.ht.service.student;

import com.ht.bean.student.Studentclass;
    /**
 * @author 王金宝
 * @date 2020/6/10 10:47
 * 
 */
public interface StudentclassService{


    int deleteByPrimaryKey(Integer classid);

    int insert(Studentclass record);

    int insertSelective(Studentclass record);

    Studentclass selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Studentclass record);

    int updateByPrimaryKey(Studentclass record);

}
