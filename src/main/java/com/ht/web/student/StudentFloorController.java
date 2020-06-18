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
    private StudentfloorService studentfloorService;//楼栋管理接口


    //表格数据渲染所要的分页数据
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

    //去修改页面
    @RequestMapping("/toUpdate")
    public String toUpdte(int id,Model model){
        Studentfloor studentFloor = studentfloorService.selectByPrimaryKey(id);
        model.addAttribute("studentFloor",studentFloor);
        return "staffupd";
    }

    //去楼栋页面
    @RequestMapping("list")
    public String list(){
        return "student/studentFloor";
    }







    //添加楼栋
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



    //修改楼栋
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



    //删除楼栋
    @RequestMapping("/del")
    public String del(Integer id) {
        studentfloorService.deleteByPrimaryKey(id);
        return "redirect:studentFloor/list";
    }
}
