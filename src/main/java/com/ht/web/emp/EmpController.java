package com.ht.web.emp;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.EmpinfoService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
/**
 * 员工管理
 *
 * */
@Controller
@RequestMapping("emp")
public class EmpController {
    @Resource
    private EmpinfoService empinfoService;

    /**
     * @param empinfo
     * @return
     * 登录
     */
    @RequestMapping("login")
    public String login(Empinfo empinfo){
        empinfo.setPhone("1111111");
        empinfo.setPassword("123456");
        Empinfo user = empinfoService.login(empinfo);
        if (user == null){
            System.out.println("失败");
        }
        System.out.println("成功");
        return "managerui/index";
    }

    /**
     * @param pager
     * @param model
     * @return
     * 分页
     */
//    @RequestMapping("list")
//    public String list(Pager pager, Model model){
//        pager.pageSize = 2;
//        //查询总行数
//        pager.page(empinfoService.selprocount());
//        pager.data = empinfoService.allPageEmp(pager);
//
//        return "managerui/index";
//    }

    /**
     * @param empinfo
     * @return
     * 添加
     */
    @RequestMapping("add")
    public String add(Empinfo empinfo){
        empinfoService.insert(empinfo);
        return "";
    }

    /**
     * @param id
     * @return
     * 删除
     */
    @RequestMapping("del")
    public String del(Integer id){
        empinfoService.deleteByPrimaryKey(id);
        return "";
    }

    @RequestMapping("emplistUi")
    public String emplistUi(){
        return "emp/emplist";
    }

    @Resource
    private JsonData jsonData;

    @RequestMapping("empdata")
    @ResponseBody
    public JsonData empdata(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(empinfoService.selprocount());
        jsonData.setCode(0);
        jsonData.setData(empinfoService.allPageEmp(pager));
        return jsonData;
    }


    /**
     * @param id
     * @param model
     * @return
     * 去修改
     */
    @RequestMapping("toupdata")
    public String toupdata(Integer id,Model model){
        Empinfo empinfo = empinfoService.selectByPrimaryKey(id);
        return "";
    }

    /**
     * @param empinfo
     * @return
     * 修改
     */
    @RequestMapping("updata")
    public String updata(Empinfo empinfo){
        empinfoService.updateByPrimaryKeySelective(empinfo);
        return "";
    }
}
