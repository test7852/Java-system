package com.ht.web.student;

import com.ht.bean.student.Studenthuor;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.student.StudenthuorService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author xmf
 * @date 2020/6/9 10:18
 */
@Controller
@RequestMapping("studenthuor")
public class studenthuorController {
    @Resource
    private StudenthuorService studenthuorService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        return "studenthuor";
    }
    @RequestMapping("/stlist")
    public String stafflist(Pager pager, Model model){
        pager.pageSize=7;
        //查询总行数
        pager.page(studenthuorService.selst());
        pager.data=studenthuorService.stlistpage(pager);
        model.addAttribute("pager",pager);
        return "stlist";
    }
    @RequestMapping("/toadd")
    public String toadd() {
        return "sfadd";
    }

    @RequestMapping("/add")
    public String add(Studenthuor studenthuor) {
        studenthuorService.insert(studenthuor);
        return "redirect:stafflist";
    }

    @RequestMapping("/toupd")
    public String toupd(int id,Model model){
        Studenthuor studenthuor = studenthuorService.selectByPrimaryKey(id);
        model.addAttribute("studenthuor",studenthuor);
        return "staffupd";
    }

    @RequestMapping("/upd")
    public String upd(Studenthuor studenthuor){
        studenthuorService.updateByPrimaryKey(studenthuor);
        return "redirect:stafflist";
    }

    @RequestMapping("/del")
    public String del(Integer hourid) {
        studenthuorService.deleteByPrimaryKey(hourid);
        return "redirect:stafflist";
    }
}
