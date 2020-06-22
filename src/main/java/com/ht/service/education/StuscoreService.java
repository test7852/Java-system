package com.ht.service.education;

import com.ht.bean.education.Stuscore;
import com.ht.util.Pager;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
public interface StuscoreService{

    /**
     * @param scoreid
     * @return
     * 根据班级成绩id删除学生成绩
     */
    int delByScoreid(Integer scoreid);

    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Map> allPageClassScore(Pager pager,int scoreid);

    /**
     * @return
     * 获取所有
     */
    List<Stuscore> allClassScore();

    /**
     * @return
     * 获取总行数
     */
    int getTotalRow(Integer scoreid);


    int deleteByPrimaryKey(Integer ssid);

    int insert(Stuscore record);

    int insertSelective(Stuscore record);

    Stuscore selectByPrimaryKey(Integer ssid);

    int updateByPrimaryKeySelective(Stuscore record);

    int updateByPrimaryKey(Stuscore record);

}
