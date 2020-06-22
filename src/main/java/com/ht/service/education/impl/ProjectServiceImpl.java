package com.ht.service.education.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.education.ProjectMapper;
import com.ht.bean.education.Project;
import com.ht.service.education.ProjectService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> allProject() {
        return projectMapper.allProject();
    }

    @Override
    public int deleteByPrimaryKey(Integer projectid) {
        return projectMapper.deleteByPrimaryKey(projectid);
    }

    @Override
    public int insert(Project record) {
        return projectMapper.insert(record);
    }

    @Override
    public int insertSelective(Project record) {
        return projectMapper.insertSelective(record);
    }

    @Override
    public Project selectByPrimaryKey(Integer projectid) {
        return projectMapper.selectByPrimaryKey(projectid);
    }

    @Override
    public int updateByPrimaryKeySelective(Project record) {
        return projectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Project record) {
        return projectMapper.updateByPrimaryKey(record);
    }

}
