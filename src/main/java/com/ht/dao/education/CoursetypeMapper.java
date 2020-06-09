package com.ht.dao.education;

import com.ht.bean.education.Coursetype;
import com.ht.bean.emp.Empinfo;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/8 20:40
 *  
 */
@Repository
public interface CoursetypeMapper {
    int deleteByPrimaryKey(Integer coursetypeid);

    int insert(Coursetype record);

    int insertSelective(Coursetype record);

    Coursetype selectByPrimaryKey(Integer coursetypeid);

    int updateByPrimaryKeySelective(Coursetype record);

    int updateByPrimaryKey(Coursetype record);

    int selCountEdu();//查询总数据

    List<Coursetype> selbypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);//分页查询

}