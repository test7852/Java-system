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
    public String
    topersonage(Model model, HttpSession session){
//        Empinfo user=(Empinfo) session.getAttribute("user");
//        Empinfo empinfo= empinfoService.selectByPrimaryKey(user.getEmp_id());
        Empinfo empinfo= empinfoService.selectByPrimaryKey(5);
        String[] strings=empinfo.getAddress().split("/");//前台参数，截取省 市 区
//        for(int i=0,len=strings.length;i<len;i++){
//            System.out.println(strings[i].toString());
//        }
        model.addAttribute("province",strings[0]);//省
        model.addAttribute("city",strings[1]);//市
        model.addAttribute("county",strings[2]);//区
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
    public Integer update(Empinfo empinfo,String province,String city,String county){
        String area=null;
        if(province!=null){
             area=province+"/"+city+"/"+county;//前端参数拼接省 市 区
        }
        empinfo.setStatus(1);
        empinfo.setAddress(area);
        System.out.println("empinfo" + empinfo.toString());
        Integer update= empinfoService.updateByPrimaryKeySelective(empinfo);
        return update;
    }






}
