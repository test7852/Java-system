package com.ht.service.student;

import com.ht.bean.student.Dept;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/15 16:00
 * 
 */
public interface DeptService{

    /**
     * @return
     * 查询总数
     */
    int getTotalRow();

    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Dept> allPageDept(Pager pager);

    /**
     * @param deptName
     * @return
     * 根据系名称查找系
     */
    Dept selectByName(String deptName);


    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

}
