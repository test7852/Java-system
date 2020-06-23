package com.ht.dao.education;

import com.ht.bean.aduit.Maintain;
import com.ht.bean.education.Coursetype;
import com.ht.bean.education.Teacherbe;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.emp.Post;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    Coursetype selName(String coursetypename);//根据姓名查询是否重复

    List<Coursetype> mhtype(@Param("pager") Pager pager,@Param("coursetype") Coursetype coursetype);//模糊查询

}