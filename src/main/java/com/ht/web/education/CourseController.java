package com.ht.web.education;

import com.ht.bean.education.Course;
import com.ht.bean.education.Coursetype;
import com.ht.bean.json.JsonData;
import com.ht.service.education.CourseService;
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
 * @date 2020/6/9 9:46
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;//课程管理

    @Resource
    private JsonData jsonData;

    //去到课程管理界面
    @RequestMapping("/courselist")
    public String courselist(){
        return "education/courselist";
    }

    //课程管理  分页查的数据
    @RequestMapping("/coursedata")
    @ResponseBody
    public JsonData jsonData(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(courseService.selCountcEdu());
        jsonData.setData(courseService.selByPage(pager));
        return jsonData;
    }

    //课程管理  根据id删除
    @RequestMapping("/cedudel")
    @ResponseBody
    public Integer coursedel(Integer courseid){
        int i = courseService.deleteByPrimaryKey(courseid);
        System.out.println("删除的id:"+courseid);
        return i;
    }

    //课程管理  修改
    @RequestMapping("/ceduupd")
    @ResponseBody
    public Integer ceduupd(Course course){
        int i = courseService.updateByPrimaryKey(course);
        return i;
    }

    //去到课程管理新增界面
    @RequestMapping("/cedutoadd")
    public String cedutoadd(Map map){
        List<Coursetype> list = courseService.selCtypes();
        map.put("list",list);
        return "education/courseadd";
    }

    //新增
    @RequestMapping("/ceduadd")
    @ResponseBody
    public Integer ceduadd(Course course){
        System.out.println(course);
        int insert = courseService.insert(course);
        return insert;
    }
}
