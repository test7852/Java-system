package com.ht.dao.student;

import com.ht.bean.emp.Post;
import com.ht.bean.student.Studentfall;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/15 16:02
 * 
 */
public interface StudentfallMapper {
    /**
     * @return
     * 查询总数
     */
    int getTotalRow();

    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Studentfall> allPagePost(Pager pager);

    /**
     * @param level
     * @return
     * 根据职位名称查找职位
     */
    Studentfall selectByName(String level);


    int deleteByPrimaryKey(Integer fallid);

    int insert(Studentfall record);

    int insertSelective(Studentfall record);

    Studentfall selectByPrimaryKey(Integer fallid);

    int updateByPrimaryKeySelective(Studentfall record);

    int updateByPrimaryKey(Studentfall record);
}