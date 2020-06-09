package com.ht.web.education;

import com.ht.bean.education.Coursetype;
import com.ht.bean.json.JsonData;
import com.ht.service.education.CoursetypeService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

//    @RequestMapping("jsondata")
//    @ResponseBody
//    public JsonData jsonData(@Param("limit")int limit , @Param("page")int page ){
//
//        Pager pager=new Pager();
//        pager.setCurrPage(page);
//        pager.setPageSize(limit);
//        jsonData.setCount(coursetypeService.selCountEdu());
//        jsonData.setCode(0);
//        jsonData.setData(coursetypeService.selByPage(pager));
//        System.out.println("jsonData = " + jsonData.toString());
//
//        return jsonData;
//    }

    //课程类别   分页查
    @RequestMapping("/edulist")
    public String edulist(Pager pager, Map map){
        //前台最大展示数
        pager.pageSize=8;
        //查询总数据
        pager.page(coursetypeService.selCountEdu());
        //查询总页数
        pager.data=coursetypeService.selByPage(pager);
        map.put("page",pager);
        return "emplist";
    }

    //课程类别   根据id删除
    @RequestMapping("/edudel")
    public String edudel(Integer coursetypeid){
        coursetypeService.deleteByPrimaryKey(coursetypeid);
        return "";
    }

    //课程类别   根据id查询  去修改界面
    @RequestMapping("/edutoupd")
    public String edutoupd(Integer coursetypeid,Map map){
        Coursetype coursetype = coursetypeService.selectByPrimaryKey(coursetypeid);
        map.put("list",coursetype);
        return "";
    }

    //课程类别   修改
    @RequestMapping("/eduupd")
    public String eduupd(Coursetype coursetype){
        coursetypeService.updateByPrimaryKey(coursetype);
        return "";
    }

    //课程类别   去新增界面
    @RequestMapping("/edutoadd")
    public String edutoadd(){
        return "";
    }

    //课程类别   新增
    @RequestMapping("/eduadd")
    public String eduadd(Coursetype coursetype){
        coursetypeService.insert(coursetype);
        return "";
    }
}
