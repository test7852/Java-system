package com.ht.dao.education;

import com.ht.bean.education.Course;
import com.ht.bean.education.Coursetype;
import com.ht.bean.education.Teacherbe;
import com.ht.bean.emp.Empinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lrq
 * @date 2020/6/11 15:44
 * 
 */
@Repository
public interface TeacherbeMapper {
    int deleteByPrimaryKey(Integer beid);

    int insert(Teacherbe record);

    int insertSelective(Teacherbe record);

    Teacherbe selectByPrimaryKey(Integer beid);

    int updateByPrimaryKeySelective(Teacherbe record);

    int updateByPrimaryKey(Teacherbe record);

    int selTeahcerbe();//查询总数据

    List<Teacherbe> selbypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);//分页查询

    List<Empinfo> selEmplist();//查询员工

}