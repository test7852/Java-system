package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Studentfloor;
import com.ht.service.student.StudentfloorService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("studentFloor")
public class StudentfloorController {
    @Resource
    private JsonData jsonData;
    @Resource
    private StudentfloorService studentfloorService;


    //楼栋数据
    @RequestMapping("data")
    @ResponseBody
    public JsonData data(@Param("limit")int limit , @Param("page")int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(studentfloorService.selCount());
        jsonData.setData(studentfloorService.sybase(pager));
        return jsonData;
    }

    //去添加页面
    @RequestMapping("/toadd")
    public String toadd() {
        return "student/flooradd";
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

    //修改楼栋资料
    @RequestMapping("/update")
    @ResponseBody
    public Integer upd(Studentfloor studentfloor){
        int i = studentfloorService.updateByPrimaryKeySelective(studentfloor);
        return i;
    }

    @RequestMapping("list")
    public String list(){
        return "student/studentFloor";
    }


    @RequestMapping("/del")
    public String del(Integer id) {
//(待删除)        studentfloorService.deleteByPrimaryKey(id);
        return "redirect:studentFloor/list";
    }
}
