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
import java.util.List;

/**
 * @author xmf
 * @date 2020/6/9 10:22
 */
@Controller
@RequestMapping("studentFloor")
public class StudentFloorController {
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
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "student/studentFloorAdd.";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Integer add(Studentfloor studentfloor) {
        List<Studentfloor> list = studentfloorService.selList();
        for (Studentfloor studentFloor:list) {
            if (studentfloor.getFloorname().equals(studentFloor.getFloorname()) || studentFloor.getFloorname()==studentfloor.getFloorname()){
                return 0;
            }
        }
        int i = studentfloorService.insert(studentfloor);
        return i;
    }

    @RequestMapping("/toUpdate")
    public String toUpdte(int id,Model model){
        Studentfloor studentFloor = studentfloorService.selectByPrimaryKey(id);
        model.addAttribute("studentFloor",studentFloor);
        return "staffupd";
    }

    //修改楼栋资料
    @RequestMapping("/update")
    @ResponseBody
    public Integer upd(Studentfloor studentfloor){
        List<Studentfloor> list = studentfloorService.selList();
        for (Studentfloor studentFloor:list) {
            if (studentfloor.getFloorname().equals(studentFloor.getFloorname()) || studentFloor.getFloorname()==studentfloor.getFloorname()){
                return 0;
            }
        }
        Integer i = studentfloorService.updateByPrimaryKeySelective(studentfloor);
        return i;
    }

    @RequestMapping("list")
    public String list(){
        return "student/studentFloor";
    }


    @RequestMapping("/del")
    public String del(Integer id) {
        studentfloorService.deleteByPrimaryKey(id);
        return "redirect:studentFloor/list";
    }
}
