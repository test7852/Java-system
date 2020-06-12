package com.ht.web.emp;

import com.ht.bean.emp.Dep;
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
            if(fdep != null){
                dep.setFname(fdep.getDepname());
            }
        }

        jsonData.setData(deps);
        return jsonData;
    }

    @RequestMapping("toadd")
    public String toadd(Map map){
        map.put("names",empinfoService.allEmpName());
        map.put("deps",depService.getAllFdep());
        return "emp/depadd";
    }

    @RequestMapping("add")
    public String add(Dep dep){
        depService.insert(dep);
        System.out.println("======");
        return "emp/deplist";
    }
}
