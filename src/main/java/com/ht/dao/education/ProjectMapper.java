package com.ht.dao.education;

import com.ht.bean.education.Project;
import com.ht.bean.education.Term;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    /**
     *
     * @return
     * 获取所有答辩项目
     */
    List<Project> allProject();
}