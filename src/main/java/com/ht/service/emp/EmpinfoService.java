package com.ht.service.emp;

import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;

import java.util.List;
import java.util.Map;

/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
public interface EmpinfoService{

    /**
     * @param empinfo
     * @return
     * 登录
     */
    Empinfo login(Empinfo empinfo);

    /**
     * @return
     * 查询总数
     */
    int selprocount();

    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Empinfo> allPageEmp(Pager pager);

    /**
     * @return
     * 获取所有员工
     */
    List<Empinfo> allEmpName();

    int deleteByPrimaryKey(Integer empId);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);

}
