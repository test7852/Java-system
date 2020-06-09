package com.ht.service.emp;

import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
public interface EmpinfoService{

    Empinfo login(Empinfo empinfo);//登录

    int selprocount();//查询总数

    List<Empinfo> allPageEmp(Pager pager);//分页

    int deleteByPrimaryKey(Integer empId);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);

}
