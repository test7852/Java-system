package com.ht.web.education;

import com.ht.bean.education.Teacherbe;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.service.education.TeacherbeService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author chun
 * @date 2020/6/11 15:52
 */
@Controller
@RequestMapping("/teacher")
public class TeacherBeController {

    @Resource
    private JsonData jsonData;

    @Resource
    private TeacherbeService teacherbeService;

    //去值班管理界面
    @RequestMapping("/teacherlist")
    public String teacherlist(){
        return "education/teacherBelist";
    }

    //值班管理 分页查的数据
    @RequestMapping("/teacherdata")
    @ResponseBody
    public JsonData jsonData(@Param("limit")int limit , @Param("page")int page ,Teacherbe teacherbe){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(teacherbeService.selTea());
        //jsonData.setData(teacherbeService.selByPage(pager));
        jsonData.setData(teacherbeService.mhtea(pager,teacherbe));
        return jsonData;
    }

    //值班管理  根据id删除
    @RequestMapping("/teacherdel")
    @ResponseBody
    public Integer teacherdel(Integer beid){
        int i = teacherbeService.deleteByPrimaryKey(beid);
        System.out.println("删除的id:"+beid);
        return i;
    }

    //去修改
    @RequestMapping("/teachertoupd")
    public String teachertoupd(Integer beid,Map map){
        Teacherbe teacherbe = teacherbeService.selectByPrimaryKey(beid);
        List<Empinfo> empinfos = teacherbeService.listEmp();
        map.put("elist",empinfos);
        map.put("tlist",teacherbe);
        return "education/teacherbeupd";
    }

    //值班管理  修改
    @RequestMapping("/teacherupd")
    @ResponseBody
    public Integer teacherupd(Teacherbe teacherbe){
        System.out.println("修改"+teacherbe);
        int i = teacherbeService.updateByPrimaryKey(teacherbe);
        return i;
    }

    //值班管理  去新增界面
    @RequestMapping("/teachertoadd")
    public String teachertoadd(Map map){//teacherBeadd
        List<Empinfo> empinfos = teacherbeService.listEmp();
        map.put("list",empinfos);
        return "education/teacherBeadd";
    }

    //值班管理  新增
    @RequestMapping("/teacheradd")
    @ResponseBody
    public Integer teacheradd(Teacherbe teacherbe){
        int insert = teacherbeService.insert(teacherbe);
        return insert;
    }
}
