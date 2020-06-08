package com.ht.service.emp;

import com.ht.bean.emp.Dep;
    /**
 * @author 王金宝
 * @date 2020/6/8 20:41
 *  
 */
public interface DepService{


    int deleteByPrimaryKey(Integer depid);

    int insert(Dep record);

    int insertSelective(Dep record);

    Dep selectByPrimaryKey(Integer depid);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);

}
