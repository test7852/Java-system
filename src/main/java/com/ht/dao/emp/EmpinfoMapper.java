package com.ht.dao.emp;

import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
public interface EmpinfoMapper {
//    登录
    Empinfo login(Empinfo empinfo);
//    查询总数
    int selprocount();
//    分页查询
    List<Empinfo> allPageEmp(Pager pager);

    int deleteByPrimaryKey(Integer empId);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);
}