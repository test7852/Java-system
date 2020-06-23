package com.ht.dao.aduit;

import com.ht.bean.aduit.Equipmentwxgl;
import com.ht.bean.aduit.Maintain;
import com.ht.bean.emp.Dep;
import com.ht.bean.student.Studentclass;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/19 8:10
 * 
 */
@Repository
public interface MaintainMapper {
    int deleteByPrimaryKey(Integer wxid);

    int insert(Maintain record);

    int insertSelective(Maintain record);

    Maintain selectByPrimaryKey(Integer wxid);

    int updateByPrimaryKeySelective(Maintain record);

    int updateByPrimaryKey(Maintain record);

    List<Maintain> mhmain(@Param("pager") Pager pager,@Param("maintain") Maintain maintain);//模糊查询

    int selMain();//查询总数据

    List<Map> byidpage(@Param("empid") Integer emp_id,@Param("pager") Pager pager,
                       @Param("maintain") Maintain maintain);//根据sessio id查询 模糊

    int byid(Integer emp_id);//id查询总数据   @Param("empid") Integer emp_id,

    List<Studentclass> selclass();//查询班级

    List<Dep> seldep();//查询部门
}