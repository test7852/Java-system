package com.ht.dao.education;

import com.ht.bean.education.Teacherbe;
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

}
