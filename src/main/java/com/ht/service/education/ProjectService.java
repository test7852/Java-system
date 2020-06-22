package com.ht.service.education;

import com.ht.bean.education.Project;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
public interface ProjectService{

    /**
     *
     * @return
     * 获取所有答辩项目
     */
    List<Project> allProject(Pager pager);

    int selprocount();

    Project selByObjName(String name);

    int deleteByPrimaryKey(Integer projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

}
