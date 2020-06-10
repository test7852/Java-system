package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Studenthuor;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.student.StudenthuorService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("studentHuor")
public class studenthuorController {
    @Resource
    private JsonData jsonData;
    @Resource
    private StudenthuorService studenthuorService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        return "studenthuor";
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


    /**
     * @param studenthuor
     * @return
     */
    @RequestMapping("/upd")
    public String upd(Studenthuor studenthuor){
        studenthuorService.updateByPrimaryKey(studenthuor);
        return "redirect:stafflist";
    }


    @RequestMapping("data")
    @ResponseBody
    public JsonData data(@Param("limit")int limit , @Param("page")int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(studenthuorService.selCount());
        jsonData.setData(studenthuorService.sybase(pager));
        return jsonData;
    }


    @RequestMapping("list")
    public String list(){
        return "student/studentHuor";
    }


    /**
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public String del(Integer id) {
        System.out.println(id);
//        studenthuorService.deleteByPrimaryKey(id);
        return "redirect:studentHuor/list";
    }

}
