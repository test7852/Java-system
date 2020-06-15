package com.ht.web.student;

import com.ht.bean.emp.Post;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Dept;
import com.ht.service.emp.PostService;
import com.ht.service.student.DeptService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 王金宝
 * @date 2020/6/15 19:23
 */
@Controller
@RequestMapping("dept")
public class DeptController {
    @Resource
    private JsonData jsonData;
    @Resource
    private DeptService deptService;


    /**
     * @param limit
     * @param page
     * @return
     * 获取系信息
     */
    @RequestMapping("deptdata")
    @ResponseBody
    public JsonData  deptdata(int limit,int page){

        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(deptService.getTotalRow());
        jsonData.setData(deptService.allPageDept(pager));
        return jsonData;
    }

    /**
     * @param dept
     * @return
     * 修改系信息
     */
    @RequestMapping("update")
    @ResponseBody
    public Boolean  update(Dept dept){
        Dept dept1 = deptService.selectByName(dept.getDeptname());
        if(dept1 == null){
            deptService.updateByPrimaryKeySelective(dept);
            return true;
        }
        return false;
    }

    /**
     * @param id
     * @return
     * 删除系
     */
    @RequestMapping("del")
    @ResponseBody
    public Boolean del(Integer id){
        int b = deptService.deleteByPrimaryKey(id);
        if(b>0){
            return true;
        }
        return false;
    }

    /**
     * @param dept
     * @return
     * 添加系
     */
    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Dept dept){
        Dept dept1 = deptService.selectByName(dept.getDeptname());
        if(dept1 == null){
            deptService.insert(dept);
            return true;
        }
        return false;
    }

    //去到系管理页面
    @RequestMapping("deptlist")
    public String postlist(){
        return "student/deptlist";
    }
    //去到系添加页面
    @RequestMapping("deptadd")
    public String postadd(){
        return "student/deptadd";
    }

}
