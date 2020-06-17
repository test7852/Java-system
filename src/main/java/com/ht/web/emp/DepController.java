package com.ht.web.emp;

import com.ht.bean.emp.Dep;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.emp.Post;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.DepService;
import com.ht.service.emp.EmpinfoService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/11 14:22
 */
@Controller
@RequestMapping("dep")
public class DepController {
    @Resource
    private DepService depService;
    @Resource
    private EmpinfoService empinfoService;
    @Resource
    private JsonData jsonData;


    /**
     * @param limit
     * @param page
     * @return
     * 获取部门列表信息
     */
    @RequestMapping("depdata")
    @ResponseBody
    public JsonData depList(int limit ,int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(depService.getTotalRow());
        List<Dep> deps = depService.allPageDep(pager);

        for(Dep dep : deps){
            Dep fdep = depService.getDepByFid(dep.getParentid());
            Empinfo emp = empinfoService.selectByPrimaryKey(dep.getChairman());
            if(fdep != null){
                dep.setFname(fdep.getDepname());
            }
            if(emp != null){
                dep.setEmpname(emp.getEmp_name());
            }
        }

        jsonData.setData(deps);
        return jsonData;
    }

    /**
     * @param map
     * @return
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Map map){
        map.put("emp",empinfoService.allEmpName());
        map.put("deps",depService.getAllFdep());
        return "emp/depadd";
    }

    /**
     * @param dep
     * @return
     * 添加部门信息
     */
    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Dep dep){
        Dep dep1 = depService.getDepByName(dep);
        if(dep1 == null){
            depService.insert(dep);
            return true;
        }
        return false;

    }

    /**
     * @param map
     * @param depid
     * @return
     * 去修改页面
     */
    @RequestMapping("toupd")
    public String toupd(Map map,Integer depid){
        map.put("emp",empinfoService.allEmpName());
        map.put("deps",depService.getAllFdep());
        Dep dep = depService.selectByPrimaryKey(depid);
        dep.setEmpname(empinfoService.selectByPrimaryKey(dep.getChairman()).getEmp_name());
        map.put("dep",dep);
        return "emp/depupd";
    }
    /**
     * @param dep
     * @return
     * 修改部门信息
     */
    @RequestMapping("upd")
    @ResponseBody
    public Boolean upd(Dep dep){
        Dep dep1 = depService.getDepByName(dep);
        Dep dep2 = depService.selectByPrimaryKey(dep.getDepid());
        if(dep1 == null){
            depService.updateByPrimaryKeySelective(dep);
            return true;
        }else if(dep.getDepname().equals(dep2.getDepname())){
            if(dep.getParentid() == dep2.getParentid()){
                depService.updateByPrimaryKeySelective(dep);
                return true;
            }
        }

        return false;
    }

    @RequestMapping("del")
    @ResponseBody
    public Boolean del(Integer depid){
        int i = depService.deleteByPrimaryKey(depid);
        if(i>0){
            return true;
        }

        return false;
    }
}
