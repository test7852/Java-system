package com.ht.dao.emp;

import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
public interface EmpinfoMapper {
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
     * 获取所有员工姓名 id
     */
    List<Empinfo> allEmpName();


    /**
     * @param postid
     * @return
     * 根据职位id找员工
     */
    List<Empinfo> selByPostId(int postid);

    /**
     * @param empinfo
     * @return
     * 找宏图软件找唯一职位
     */
    Empinfo selectcrux(Empinfo empinfo);

    /**
     * @param empinfo
     * @return
     * 根据号码找员工
     */
    Empinfo getEmpByName(Empinfo empinfo);

    /**
     * @return
     * 获取所有员工
     */
    List<Empinfo> list();

    /**
     * @param name
     * @return
     * 根据名字找对象
     */
    List<Empinfo> empinfoByName(String name);

    int deleteByPrimaryKey(Integer empId);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);
}