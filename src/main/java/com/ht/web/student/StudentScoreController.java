package com.ht.web.student;

import com.ht.bean.education.Course;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Student;
import com.ht.bean.student.StudentScore;
import com.ht.service.education.CourseService;
import com.ht.service.student.StudentScoreService;
import com.ht.service.student.StudentService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author xmf
 * @date 2020/6/10 14:35
 * 学生成绩
 */
@Controller
@RequestMapping("score")
public class StudentScoreController {
    @Resource
    private StudentScoreService studentScoreService;//学生成绩
    @Resource
    private CourseService courseService;//课程管理
    @Resource
    private StudentService studentService;//学生

    //去到列表+
    @RequestMapping("scorelistUi")
    public String scorelistUi(){
        return "student/scorelist";
    }

    //加载数据
    @Resource
    private JsonData jsonData;

    @RequestMapping("scoredata")
    @ResponseBody
    public JsonData empdata(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(studentScoreService.getTotalRow());
        jsonData.setCode(0);
        jsonData.setData(studentScoreService.allPageStuScore(pager));
        return jsonData;
    }

    /**
     * @param
     * @return
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Map map){
        List<Student> studentList= studentService.allStu();
        List<Course> courseList= courseService.selCourse();
        map.put("student", studentList);
        map.put("course", courseList);
        return "student/scoreadd";
    }


    /**
     * @param studentScore
     * @return
     * 添加学生信息
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(StudentScore studentScore,HttpSession session){
//        Empinfo empinfo= (Empinfo)session.getAttribute("user");
//        studentScore.setEmpid(empinfo.getEmp_id());
//        System.out.println("添加："+studentScore.toString());
//        Student stu=studentService.selectByPrimaryKey(studentScore.getStuid());
//        studentScoreService.insert(studentScore);
//        Classscore classscore=new Classscore();
//        classscore.setScoreid(studentScore.getScoreid());
//        classscore.setEmpid(studentScore.getEmpid());
//        classscore.setClazz(String.valueOf(stu.getClazz()));
//        classscoreService.insert(classscore);
       return "true";
    }

    /**
     * @param stuid
     * @param map
     * @return
     * 去修改页面
     */
    @RequestMapping("toupd")
    public String toupd(int stuid,Map map){
        map.put("",studentScoreService.selectByPrimaryKey(stuid));
        return "";
    }

    /**
     * @param studentScore
     * @return
     * 修改学生信息
     */
    @RequestMapping("upd")
    @ResponseBody
    public Integer upd(StudentScore studentScore){
        int updatacurr = studentScoreService.updateByPrimaryKey(studentScore);
        System.out.println("修改："+studentScore.toString());
        return updatacurr;
    }


    /**
     * @param id
     * @return
     * 删除学生
     */
    @RequestMapping("del")
    public String del(int id){
        studentScoreService.deleteByPrimaryKey(id);
        System.out.println("删除："+id);
        return "redirect:score/scorelistUi";
    }
}
