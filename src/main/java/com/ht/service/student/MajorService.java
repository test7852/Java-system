package com.ht.service.student;

import com.ht.bean.student.Major;
import com.ht.util.Pager;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/15 20:29
 * 
 */
public interface MajorService{
    List<Major> byDeptId (Integer id);//根据系id查找该系下面的所有专业

    List<Major> selList();//查询所有

    int selCount();//查询总数

    List<Major> sybase(Pager pager);//分页

    Major selectByName(String majorname);

    int deleteByPrimaryKey(Integer majorid);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer majorid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

}
