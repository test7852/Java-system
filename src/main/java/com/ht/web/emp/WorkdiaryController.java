package com.ht.web.emp;

import com.ht.bean.emp.Empinfo;
import com.ht.bean.emp.Workdiary;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.WorkdiaryService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author roger
 * @date 2020/6/12 20:48
 */
@Controller
@RequestMapping("workdiary")
public class WorkdiaryController {

    @Resource
    private WorkdiaryService workdiaryService;

    @Resource
    private JsonData jsonData;


    /**
     * @return 周报数据
     */
    @RequestMapping("workdiarydata")
    @ResponseBody
    public JsonData workdiarydata(@Param("limit")int limit , @Param("page")int page){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(workdiaryService.selworkcount());
        List<Workdiary> list = workdiaryService.allPageWorkdiary(pager);
        jsonData.setData(workdiaryService.allPageWorkdiary(pager));
        return jsonData;
    }

    /**
     * @return 我的周报数据
     */
    @RequestMapping("myworkdiarydata")
    @ResponseBody
    public JsonData myworkdiarydata(@Param("limit")int limit , @Param("page")int page, HttpServletRequest request){
        Pager pager=new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(workdiaryService.selworkcount());
        HttpSession session = request.getSession();
        Empinfo user = (Empinfo) session.getAttribute("user");
        Integer id = user.getEmp_id();
        jsonData.setData(workdiaryService.myworkdiary(id));
        return jsonData;
    }

    //查看周报数据
    @RequestMapping("searchwork")
    public String searchwork(Integer worklogid, Model model){
        List list = workdiaryService.searchWorkdiary(worklogid);
        model.addAttribute("list",list);
        return "emp/searchWorkdiary";
    }

    //去到周报修改页面
    @RequestMapping("toeditwork")
    public String toeditwork(Integer worklogid,Model model){
        Workdiary workdiary = workdiaryService.selectByPrimaryKey(worklogid);
        model.addAttribute("list",workdiary);
        return "emp/editWorkdiary";
    }

    //修改我的周報
    @RequestMapping("editwork")
    @ResponseBody
    public Integer editwork(Workdiary workdiary){
        int i = workdiaryService.updateByPrimaryKeySelective(workdiary);
        return i;
    }

    //删除我的周报数据
    @RequestMapping("delworkdiary")
    public Integer delworkdiary(Integer id){
        int i = workdiaryService.deleteByPrimaryKey(id);
        return i;
    }

    //去到添加周报页面
    @RequestMapping("toaddwork")
    public String toaddwork(HttpSession session,Map map){
        Empinfo empinfo=(Empinfo)session.getAttribute("user");
        map.put("emp",empinfo);
        return "emp/addWorkdiary";
    }

    //添加周报
    @RequestMapping("addwork")
    @ResponseBody
    public Integer addwork(Workdiary workdiary,int emp_id){
        workdiary.setEmpid(emp_id);
        workdiary.setWorkday(new SimpleDateFormat("yyyy-MM-dd ").format(new Date()));
        int i = workdiaryService.insert(workdiary);
        return i;
    }
}
