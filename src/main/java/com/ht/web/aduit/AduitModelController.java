package com.ht.web.aduit;

import com.ht.bean.aduit.Aduitmodel;
import com.ht.bean.emp.Dep;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.emp.Post;
import com.ht.bean.json.JsonData;
import com.ht.service.aduit.AduitmodelService;
import com.ht.service.emp.DepService;
import com.ht.service.emp.EmpinfoService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/16 9:27
 */
@Controller
@RequestMapping("aduitmodel")
public class AduitModelController {
    @Resource
    private DepService depService;
    @Resource
    private AduitmodelService aduitmodelService;
    @Resource
    private JsonData jsonData;


    /**
     * @param limit
     * @param page
     * @return
     * 获取考核指标列表信息
     */
    @RequestMapping("listdata")
    @ResponseBody
    public JsonData depList(int limit ,int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(aduitmodelService.getTotalRow());
        List<Aduitmodel> aduitmodels = aduitmodelService.allPageAduitmodel(pager);

        for(Aduitmodel aduitmodel : aduitmodels){
            Dep dep = depService.getDepByFid(aduitmodel.getDepid());
            if(dep != null){
                aduitmodel.setDepname(dep.getDepname());
            }
        }

        jsonData.setData(aduitmodels);
        return jsonData;
    }

    /**
     * @param map
     * @return
     * 去考核指标添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Map map){
        map.put("deps",depService.getAllFdep());
        return "aduit/aduitmodeladd";
    }

    /**
     * @param id
     * @return
     * 获取子级部门
     */
    @RequestMapping("getdep")
    @ResponseBody
    public List<Dep> getdep(Integer id){
        return depService.getDepByid(id);
    }

    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Aduitmodel aduitmodel,Integer depid2){
        System.out.println(depid2);
        if(depid2 != 0){
            aduitmodel.setDepid(depid2);
        }
        int b = aduitmodelService.insert(aduitmodel);
        if(b>0){
            return true;
        }
        return false;
    }

    /**
     * @param map
     * @param id
     * @return
     * 去修改页面
     */
    @RequestMapping("toupd")
    public String toupd(Map map,Integer id){
        Aduitmodel aduitmodel = aduitmodelService.selectByPrimaryKey(id);
        System.out.println(aduitmodel.toString());
        Dep dep = depService.selectByPrimaryKey(aduitmodel.getDepid());
        map.put("fdeps",depService.getAllFdep());//返回所有父级对象
        map.put("aduitmodel",aduitmodel);//返回当前考核对象

        if(dep.getParentid() != 0){//判断当前部门是不是一级部门

            dep = depService.getDepByFid(dep.getParentid());//获取父级对象

        }
        map.put("fdep",dep);//将父级对象传过去
        map.put("deps",depService.getDepByid(dep.getDepid()));//获取所有子级
        return "aduit/aduitmodelupd";
    }
    /**
     * @param aduitmodel
     * @param depid2
     * @return
     * 修改部门信息
     */
    @RequestMapping("upd")
    @ResponseBody
    public Boolean upd(Aduitmodel aduitmodel,Integer depid2){
        System.out.println(depid2);
        if(depid2 != 0){
            aduitmodel.setDepid(depid2);
        }
        int b = aduitmodelService.updateByPrimaryKeySelective(aduitmodel);
        if(b>0){
            return true;
        }
        return false;

    }

    @RequestMapping("del")
    @ResponseBody
    public Boolean del(Integer id){
        int i = aduitmodelService.deleteByPrimaryKey(id);
        if(i>0){
            return true;
        }

        return false;
    }



}
