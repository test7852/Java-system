package com.ht.web.student;

import com.ht.bean.student.Studentfloor;
import com.ht.service.student.StudentfloorService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author xmf
 * @date 2020/6/9 10:22
 */
@Controller
@RequestMapping("Studentfloor")
public class StudentfloorController {
    @Resource
    private StudentfloorService studentfloorService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        return "Studentfloor";
    }

    @RequestMapping("/stlist")
    public String stafflist(Pager pager, Model model){
        pager.pageSize=7;
        //查询总行数
        pager.page(studentfloorService.selsf());
        pager.data=studentfloorService.sflistpage(pager);
        model.addAttribute("pager",pager);
        return "stlist";
    }
    @RequestMapping("/toadd")
    public String toadd() {
        return "sfadd";
    }

    @RequestMapping("/add")
    public String add(Studentfloor studentfloor) {
        studentfloorService.insert(studentfloor);
        return "redirect:stafflist";
    }

    @RequestMapping("/toupd")
    public String toupd(int id,Model model){
        Studentfloor studentfloor = studentfloorService.selectByPrimaryKey(id);
        model.addAttribute("studentfloor",studentfloor);
        return "staffupd";
    }

    @RequestMapping("/upd")
    public String upd(Studentfloor studentfloor){
        studentfloorService.updateByPrimaryKey(studentfloor);
        return "redirect:stafflist";
    }

    @RequestMapping("/del")
    public String del(Integer floorid) {
        studentfloorService.deleteByPrimaryKey(floorid);
        return "redirect:stafflist";
    }
}
