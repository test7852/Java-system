package com.ht.web.education;

import com.ht.bean.education.Course;
import com.ht.bean.education.Coursetype;
import com.ht.bean.json.JsonData;
import com.ht.service.education.CoursetypeService;
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
 * @date 2020/6/9 9:45
 */
@Controller
@RequestMapping("/coursetype")
public class CourseTypeController {

    @Resource
    private CoursetypeService coursetypeService;//课程类别

    @Resource
    private JsonData jsonData;

    //去到课程类别界面
    @RequestMapping("/coursetypelist")
    public String coursetypelist(){
        return "education/coursetypelist";
    }

    //课程管理  分页查的数据
    @RequestMapping("/coursetypedata")
    @ResponseBody
    public JsonData jsonData(@Param("limit")int limit , @Param("page")int page ,Coursetype coursetype){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(coursetypeService.selCountEdu());
        //jsonData.setData(coursetypeService.selByPage(pager));
        jsonData.setData(coursetypeService.mhtype(pager,coursetype));
        return jsonData;
    }

    //课程管理  根据id删除
    @RequestMapping("/coursetypedel")
    @ResponseBody
    public Integer coursedel(Integer coursetypeid){
        int i = coursetypeService.deleteByPrimaryKey(coursetypeid);
        System.out.println("删除的id:"+coursetypeid);
        return i;
    }

    //课程管理  修改
    @RequestMapping("/coursetypeupd")
    @ResponseBody
    public Boolean coursetypeupd(Coursetype coursetype){
        Coursetype coursetype1 = coursetypeService.selName(coursetype.getCoursetypename());
        if(coursetype1 == null){
            int i = coursetypeService.updateByPrimaryKey(coursetype);
            return true;
        }
        return false;
    }

    //去新增
    @RequestMapping("/coursetypetoadd")
    public String coursetypetoadd(){
        return "education/coursetypeadd";
    }

    //新增
    @RequestMapping("/coursetypeadd")
    @ResponseBody
    public Boolean coursetypeadd(Coursetype coursetype){
        System.out.println(coursetype);
        Coursetype c = coursetypeService.selName(coursetype.getCoursetypename());
        if( c == null){//如果数据库没有这个姓名就可以新增
            coursetypeService.insert(coursetype);
            return true;
        }
        return false;
    }
}
