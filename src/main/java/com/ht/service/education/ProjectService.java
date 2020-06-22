package com.ht.service.education;

import com.ht.bean.education.Project;
    /**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
public interface ProjectService{


    int deleteByPrimaryKey(Integer projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

}
