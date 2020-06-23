package com.ht.service.aduit;

import com.ht.bean.aduit.Equipmentwxgl;
import com.ht.bean.education.Coursetype;
import com.ht.bean.emp.Dep;
import com.ht.bean.student.Dept;
import com.ht.bean.student.Student;
import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/16 20:43
 * 
 */
public interface EquipmentwxglService{


    int deleteByPrimaryKey(Integer wxid);

    int insert(Equipmentwxgl record);

    int insertSelective(Equipmentwxgl record);

    Equipmentwxgl selectByPrimaryKey(Integer wxid);

    int updateByPrimaryKeySelective(Equipmentwxgl record);

    int updateByPrimaryKey(Equipmentwxgl record);

    int selEqui();//查询总数据

    List<Equipmentwxgl> selByPage(Pager pager);//分页查询

    List<Studentclass> selclass();//查询班级

    List<Dep> seldep();//查询部门
}
