package com.ht.service.aduit;

import com.ht.bean.aduit.Maintain;
import com.ht.bean.emp.Dep;
import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/19 8:10
 * 
 */
public interface MaintainService{


    int deleteByPrimaryKey(Integer wxid);

    int insert(Maintain record);

    int insertSelective(Maintain record);

    Maintain selectByPrimaryKey(Integer wxid);

    int updateByPrimaryKeySelective(Maintain record);

    int updateByPrimaryKey(Maintain record);

    List<Maintain> mhmain(Pager pager,Maintain maintain);//模糊查询

    int selMain();//查询总数据

    List<Studentclass> selclass();//查询班级

    int byid(Integer emp_id);//id查询总数据

    List<Dep> seldep();//查询部门  Integer emp_id,

    List<Map> byidpage(Integer emp_id,Pager pager,Maintain maintain);//根据sessio id查询 模糊

}
