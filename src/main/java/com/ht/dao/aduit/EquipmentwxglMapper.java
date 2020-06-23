package com.ht.dao.aduit;

import com.ht.bean.aduit.Equipmentwxgl;
import com.ht.bean.education.Coursetype;
import com.ht.bean.emp.Dep;
import com.ht.bean.student.Dept;
import com.ht.bean.student.Student;
import com.ht.bean.student.Studentclass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/16 20:43
 * 
 */
@Repository
public interface EquipmentwxglMapper {
    int deleteByPrimaryKey(Integer wxid);

    int insert(Equipmentwxgl record);

    int insertSelective(Equipmentwxgl record);

    Equipmentwxgl selectByPrimaryKey(Integer wxid);

    int updateByPrimaryKeySelective(Equipmentwxgl record);

    int updateByPrimaryKey(Equipmentwxgl record);

    int selEqui();//查询总数据

    List<Equipmentwxgl> selbypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);//分页查询

    List<Studentclass> selclass();//查询班级

    List<Dep> seldep();//查询部门
}