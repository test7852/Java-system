package com.ht.web.aduit;

import com.ht.bean.aduit.Holiday;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Studentfloor;
import com.ht.bean.student.Studenthuor;
import com.ht.service.aduit.HolidayService;
import com.ht.util.Contants;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 王钟华
 * @date 2020-06-19 19:21
 */
@RequestMapping("holiday")
@Controller
public class HolidayController {
    @Resource
    private JsonData jsonData;

    @Resource
    private HolidayService holidayService;


    /**
     * @return
     * 去我的请假页面
     */
    @RequestMapping("list")
    public String list(){
        return "aduit/holidayList";
    }


    /**
     * @return
     * 去请假申请页面
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "aduit/holidayAdd";
    }


    /**
     * @return
     * 添加请假申请
     */
    @RequestMapping("/add")
    @ResponseBody
    public Integer add(Holiday holiday,HttpSession session) {
        holiday.setStatus(Contants.HOLIDAY_LOADING);
        Empinfo empinfo = (Empinfo) session.getAttribute("user");
        holiday.setEmpid(empinfo.getEmp_id());
        Integer i = holidayService.insert(holiday);
        return i;
    }


    @RequestMapping("data")
    @ResponseBody
    public JsonData data(@Param("limit")int limit , @Param("page")int page, HttpSession session){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);

        Empinfo empinfo = (Empinfo) session.getAttribute("user");
        jsonData.setCount(holidayService.selCount());
//        jsonData.setData(holidayService.sybase(pager,empinfo.getEmp_id()));
        jsonData.setData(holidayService.sybase(pager,6));
        return jsonData;
    }

}
