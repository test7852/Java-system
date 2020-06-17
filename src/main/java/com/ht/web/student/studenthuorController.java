package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Studentfloor;
import com.ht.bean.student.Studenthuor;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.student.StudentfallService;
import com.ht.service.student.StudentfloorService;
import com.ht.service.student.StudenthuorService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Resource
    private StudentfloorService studentfloorService;
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

    @RequestMapping("/toAdd")
    public String toAdd(Map map) {
        List<Studentfloor> studentFloorList = studentfloorService.selList();
        map.put("studentFloorList",studentFloorList);
        return "student/studentHuorAdd";
    }

    @RequestMapping("/add")
    public String add(Studenthuor studenthuor) {
        studenthuorService.insert(studenthuor);
        return "redirect:studentHuor/list";
    }

    /**
     * @param studenthuor
     * @return 修改数据
     */
    @RequestMapping("/update")
    @ResponseBody
    public Integer upd(Studenthuor studenthuor){
        int i = studenthuorService.updateByPrimaryKeySelective(studenthuor);
        return i;
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
        studenthuorService.deleteByPrimaryKey(id);
        return "redirect:studentHuor/list";
    }

}
