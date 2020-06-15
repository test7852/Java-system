package com.ht.web.emp;

import com.ht.bean.emp.Empinfo;
import com.ht.bean.emp.Workdiary;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.WorkdiaryService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
}
