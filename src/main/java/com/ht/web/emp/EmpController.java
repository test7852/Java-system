package com.ht.web.emp;
import com.ht.bean.emp.Dep;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.emp.Post;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.DepService;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.emp.PostService;
import com.ht.util.Contants;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    private DepService depService;
    @Resource
    private PostService postService;
    @Resource
    private JsonData jsonData;


    /**
     * @param empinfo
     * @return
     * 登录操作
     */
    @RequestMapping("login")
    @ResponseBody
    public Boolean login(Empinfo empinfo, HttpSession session){
        Empinfo user = empinfoService.login(empinfo);
        if (user == null || user.getStatus() == Contants.STATUS_SW){
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
        List<Empinfo> list = (empinfoService.allPageEmp(pager));
        //根据部门id和职务id去找
        for (Empinfo empinfo : list){
            Dep dep = depService.selectByPrimaryKey(empinfo.getDep_id());
            Post post = postService.selectByPrimaryKey(empinfo.getPost_Id());
            //赋值
            empinfo.setDepname(dep.getDepname());
            empinfo.setPostname(post.getPos_Name());
        }
        jsonData.setData(list);

        return jsonData;
    }

    /**
     * @param
     * @return
     * 去到添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Model model){
        List<Dep> deps = depService.list();
        model.addAttribute("deps",deps);
        return "emp/empadd";
    }

    @RequestMapping("selectpost")
    @ResponseBody
    public List<Post> selectpost(Integer id,Empinfo empinfo){
        if(id == 1){
            List<Post> list = postService.elselist();
            return list;
        }
        List<Post> list = postService.selolist();
        return list;
    }

    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Empinfo empinfo) {
        Empinfo cf = empinfoService.getEmpByName(empinfo);
        System.out.println(cf);
        if (cf == null){
            empinfo.setStatus(Contants.STATUS_SU);//默认开启
            empinfoService.insert(empinfo);
            return true;
        }
        return false;
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
    public Boolean updata(Empinfo empinfo){
        Empinfo empinfo1 = empinfoService.getEmpByName(empinfo);//根据号码找
        Empinfo empinfo2 = empinfoService.selectByPrimaryKey(empinfo.getEmp_id());//根据id找
        if (empinfo1 == null){
            empinfoService.updateByPrimaryKeySelective(empinfo);
            return true;
        }else if (empinfo2.getPhone().equals(empinfo.getPhone())){
            empinfoService.updateByPrimaryKeySelective(empinfo);
            return true;
        }
        return false;
    }

    /**
     * @param empinfo
     * @return
     * 修改状态
     */
    @RequestMapping("set")
    @ResponseBody
    public Boolean set(Empinfo empinfo){
        if (empinfo.getStatus() == Contants.STATUS_SU){
            empinfo.setStatus(Contants.STATUS_SW);
        }else {
            empinfo.setStatus(Contants.STATUS_SU);
        }
        empinfoService.updateByPrimaryKeySelective(empinfo);
        return true;
    }

    /**
     * @param empinfo
     * @return
     * 重置密码
     */
    @RequestMapping("reset")
    @ResponseBody
    public Boolean reset(Empinfo empinfo){
        if (Contants.PASSWORD_TA.equals(empinfo.getPassword())){
           return false;
        }
        empinfo.setPassword(Contants.PASSWORD_TA);
        empinfoService.updateByPrimaryKeySelective(empinfo);
        return true;
    }

    /**
     * @param empinfo
     * @return
     * 编辑
     */
    @RequestMapping("toedit")
    public String edit(Empinfo empinfo,Model model){
        Empinfo empinfo1 = empinfoService.selectByPrimaryKey(empinfo.getEmp_id());
        //获取部门
        List<Dep> deps = depService.list();
        //获取职位
        List<Post> posts = postService.list();
        model.addAttribute("deps",deps);
        model.addAttribute("posts",posts);
        model.addAttribute("emp",empinfo1);
        return "emp/empedit";
    }

    /**
     * @param empinfo
     * @return
     * 编辑
     */
    @RequestMapping("toword")
    public String word(Empinfo empinfo){
        System.out.println(empinfo.getEmp_id());
        return "emp/emppapers";
    }

}
