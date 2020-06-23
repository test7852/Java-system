package com.ht.service.education;

import com.ht.bean.aduit.Maintain;
import com.ht.bean.education.Coursetype;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/8 20:40
 *  
 */
public interface CoursetypeService{


    int deleteByPrimaryKey(Integer coursetypeid);

    int insert(Coursetype record);

    int insertSelective(Coursetype record);

    Coursetype selectByPrimaryKey(Integer coursetypeid);

    int updateByPrimaryKeySelective(Coursetype record);

    int updateByPrimaryKey(Coursetype record);

    int selCountEdu();//查询总数据

    List<Coursetype> selByPage(Pager pager);//分页查询

    Coursetype selName(String coursetypename);

    List<Coursetype> mhtype(Pager pager, Coursetype coursetype);//模糊查询
}
