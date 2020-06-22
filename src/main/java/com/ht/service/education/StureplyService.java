package com.ht.service.education;

import com.ht.bean.education.Stureply;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
public interface StureplyService{

    /**
     * @param replyid
     * @return
     * 根据班级成绩id删除学生成绩
     */
    int delByStuReply(Integer replyid);

    /**
     * @param pager
     * @param replyid
     * @return
     * 分页查询
     */
    List<Map> allPageClassReply(Pager pager,Integer replyid);

    /**
     * @return
     * 获取所有
     */
    List<Stureply> allClassReply();

    /**
     * @param replyid
     * @return
     * 获取总行数
     */
    int getTotalRow(Integer replyid);

    int deleteByPrimaryKey(Integer srid);

    int insert(Stureply record);

    int insertSelective(Stureply record);

    Stureply selectByPrimaryKey(Integer srid);

    int updateByPrimaryKeySelective(Stureply record);

    int updateByPrimaryKey(Stureply record);

}
