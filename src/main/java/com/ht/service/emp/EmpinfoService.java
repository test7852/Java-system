package com.ht.service.emp;

import com.ht.bean.emp.Empinfo;
    /**
 * @author lrq
 * @date 2020/6/7 20:19
 */
public interface EmpinfoService{

    Empinfo login(Empinfo empinfo);//登录

    int deleteByPrimaryKey(Integer empId);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);

}
