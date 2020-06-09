package com.ht.web.education;

import com.ht.bean.education.Course;
import com.ht.service.education.CourseService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    //课程管理  分页查
    @RequestMapping("/cedulist")
    public String cedulist(Pager pager, Map map){
        //前台最大展示数
        pager.pageSize=8;
        //查询总数据
        pager.page(courseService.selCountcEdu());
        //查询总页数
        pager.data=courseService.selByPage(pager);
        map.put("page",pager);
        return "";
    }



    //课程管理   根据id删除
    @RequestMapping("/cedudel")
    public String cedudel(Integer coursetypeid){
        courseService.deleteByPrimaryKey(coursetypeid);
        return "";
    }

    //课程管理   根据id查询  去修改界面
    @RequestMapping("/cedutoupd")
    public String cedutoupd(Integer courseid,Map map){
        Course course = courseService.selectByPrimaryKey(courseid);
        map.put("list",course);
        return "";
    }

    //课程管理   修改
    @RequestMapping("/ceduupd")
    public String ceduupd(Course course){
        courseService.updateByPrimaryKey(course);
        return "";
    }

    //课程管理   去新增界面
    @RequestMapping("/cedutoadd")
    public String cedutoadd(){
        return "";
    }

    //课程管理   新增
    @RequestMapping("/ceduadd")
    public String ceduadd(Course course){
        courseService.insert(course);
        return "";
    }
}
