package com.ht.dao.education;

import com.ht.bean.education.Classscore;
import com.ht.bean.student.StudentScore;
import com.ht.util.Pager;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/19 19:09
 * 
 */
public interface ClassscoreMapper {
    int deleteByPrimaryKey(Integer cscoreid);

    int insert(Classscore record);

    int insertSelective(Classscore record);

    Classscore selectByPrimaryKey(Integer cscoreid);

    int updateByPrimaryKeySelective(Classscore record);

    int updateByPrimaryKey(Classscore record);


    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Map> allPageClassScore(Pager pager);

    /**
     * @return
     * 获取总行数
     */
    int getTotalRow();

    /**
     * @return
     * 获取最新的ID
     */
    int getId();
}