package com.ht.service.impl;

import com.ht.bean.Empinfo;
    /**
 * @author lrq
 * @date 2020/6/7 20:19
 */
public interface EmpinfoService{


    int deleteByPrimaryKey(Integer empId);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);

}
