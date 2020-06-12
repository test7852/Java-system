package com.ht.web.emp;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.EmpinfoService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 员工管理
 *
 * */
@Controller
@RequestMapping("emp")
public class EmpController {
    @Resource
    private EmpinfoService empinfoService;
    @Resource
    private JsonData jsonData;


    @RequestMapping("toAdd")
    public String toAdd(){
        return "emp/empadd";
    }
    /**
     * @param empinfo
     * @return
     * 登录操作
     */
    @RequestMapping("login")
    @ResponseBody
    public Boolean login(Empinfo empinfo, HttpSession session){
        Empinfo user = empinfoService.login(empinfo);
        if (user == null){
            return false;
        }
        session.setAttribute("user",user);
        return true;
    }

    /**
     * @param limit
     * @param page
     * @return
     * 获取员工资料
     */
    @RequestMapping("empdata")
    @ResponseBody
    public JsonData empdata(@Param("limit")int limit , @Param("page")int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(empinfoService.selprocount());
        jsonData.setData(empinfoService.allPageEmp(pager));
        return jsonData;
    }


    /**
     * @param
     * @return 去到添加页面
     * 添加
     */
    @RequestMapping("add")
    public void add(Empinfo empinfo){
        empinfoService.insert(empinfo);
    @RequestMapping("toadd")
    public String toadd(){
        return "emp/empadd";
    }

    /**
     * @param id
     * @return
     * 删除
     */
    @RequestMapping("del")
    @ResponseBody
    public Boolean del(@Param("id") Integer id){
        int b = empinfoService.deleteByPrimaryKey(id);
        if (b == 0){
            return false;
        }
        return true;
    }

    /**
     * @param empinfo
     * @return
     * 修改
     */
    @RequestMapping("update")
    @ResponseBody
    public Integer updata(Empinfo empinfo){
        System.out.println("empinfo.toString() = " + empinfo.toString());
        int updatacurr = empinfoService.updateByPrimaryKeySelective(empinfo);
        return updatacurr;
    }
}
