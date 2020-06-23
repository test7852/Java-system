package com.ht.service.education;

import com.ht.bean.education.Course;
import com.ht.bean.education.Teacherbe;
import com.ht.bean.emp.Empinfo;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lrq
 * @date 2020/6/11 15:44
 * 
 */
public interface TeacherbeService{


    int deleteByPrimaryKey(Integer beid);

    int insert(Teacherbe record);

    int insertSelective(Teacherbe record);

    Teacherbe selectByPrimaryKey(Integer beid);

    int updateByPrimaryKeySelective(Teacherbe record);

    int updateByPrimaryKey(Teacherbe record);

    int selTea();//查询总数据

    List<Teacherbe> selByPage(Pager pager);//分页查询

    List<Empinfo> listEmp();//查询员工

    List<Map> mhtea(@Param("pager")Pager pager, @Param("teacherbe") Teacherbe teacherbe);//模糊查询

}
