package com.ht.web.personage;

import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.DepService;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.emp.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 半口香甜吴一玄
 */

@Controller
@RequestMapping("personage")
public class personController {

    @Resource
    private EmpinfoService empinfoService;

    /**
     * 查找当前用户的资料
     * @param
     * @return
     */
    @RequestMapping("topersonage")
    public String topersonage(Model model, HttpSession session){
//        Empinfo user = (Empinfo)session.getAttribute("user");
//        Empinfo empinfo= empinfoService.selectByPrimaryKey(user.getEmp_id());
        Empinfo empinfo= empinfoService.selectByPrimaryKey(1);
        model.addAttribute("person",empinfo);
        return "personage/personage";
    }

    /**
     * @param empinfo
     * @return
     * 修改
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(Empinfo empinfo){
        System.out.println("empinfo.toString() = " + empinfo.toString());
        empinfoService.updateByPrimaryKeySelective(empinfo);
        return "personage/personage";
    }






}
