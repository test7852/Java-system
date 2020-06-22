package com.ht.web.education;

import com.ht.bean.education.Classscore;
import com.ht.bean.education.Coursetype;
import com.ht.bean.education.Stuscore;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.emp.Workdiary;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Student;
import com.ht.service.education.ClassscoreService;
import com.ht.service.education.CourseService;
import com.ht.service.education.StuscoreService;
import com.ht.service.education.TermService;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.emp.WorkdiaryService;
import com.ht.service.student.StudentService;
import com.ht.service.student.StudentclassService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/20 8:32
 */
@Controller
@RequestMapping("classscore")
public class ClassScoreController {
    @Resource
    private ClassscoreService classscoreService;
    @Resource
    private CourseService courseService;
    @Resource
    private StudentclassService studentclassService;
    @Resource
    private TermService termService;
    @Resource
    private StudentService studentService;
    @Resource
    private StuscoreService stuscoreService;
    @Resource
    private JsonData jsonData;


    /**
     * @param limit
     * @param page
     * @return
     * 获取数据
     */
    @RequestMapping("listdata")
    @ResponseBody
    public JsonData listdata(@Param("limit")int limit , @Param("page")int page){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(classscoreService.getTotalRow());
        jsonData.setData(classscoreService.allPageClassScore(pager));
        return jsonData;
    }

    /**
     * @param map
     * @return
     * 去班级成绩添加页面
     */
    @RequestMapping("/toadd")
    public String cedutoadd(Map map){
        map.put("courses",courseService.selCourse());
        map.put("calsss",studentclassService.selList());
        map.put("terms",termService.allTerm());
        return "education/classscoreadd";
    }


    /**
     * @param classscore
     * @param session
     * @return
     * 添加
     */
    @RequestMapping("/add")
    @ResponseBody
    public Boolean add(Classscore classscore, HttpSession session){
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(new Date());
        classscore.setScoretime(createdate);
        Empinfo emp = (Empinfo) session.getAttribute("user");
        classscore.setEmpid(emp.getEmp_id());
        int i =classscoreService.insert(classscore);
        Integer id = classscoreService.getId();
        List<Student> list =studentService.allStuClazz(classscore.getClassid());
        for (Student student:list){
            Stuscore stuscore = new Stuscore();
            stuscore.setScoreid(id);
            stuscore.setStuid(student.getStudid());
            i=stuscoreService.insert(stuscore);
        }
        if(i >0){
            return true;
        }
       return false;
    }

    /**
     * @param id
     * @param map
     * @return
     * 去班级成绩修改页面
     */
    @RequestMapping("/toupd")
    public String toupd(Integer id,Map map){
        map.put("classscore",classscoreService.selectByPrimaryKey(id));
        map.put("courses",courseService.selCourse());
        map.put("calsss",studentclassService.selList());
        map.put("terms",termService.allTerm());
        return "education/classscoreupd";
    }


    @RequestMapping("look")
    public String modellist(Integer scoreid,Map map){
        map.put("scoreid",scoreid);
        return "education/stuscorelist";
    }
    /**
     * @param classscore
     * @return
     * 修改
     */
    @RequestMapping("/upd")
    @ResponseBody
    public Boolean upd(Classscore classscore){
        Classscore classscore2 = classscoreService.selectByPrimaryKey(classscore.getCscoreid());

        if(classscore.getClassid() != classscore2.getClassid() ){
            System.out.println("lai");
            stuscoreService.delByScoreid(classscore.getCscoreid());
            List<Student> list =studentService.allStuClazz(classscore.getClassid());
            for (Student student:list){
                Stuscore stuscore = new Stuscore();
                stuscore.setScoreid(classscore.getCscoreid());
                stuscore.setStuid(student.getStudid());
                stuscoreService.insert(stuscore);
            }
        }
        int i =classscoreService.updateByPrimaryKeySelective(classscore);
        if(i >0){
            return true;
        }
        return false;
    }


    /**
     * @param id
     * @return
     * 删除
     */
    @RequestMapping("/del")
    @ResponseBody
    public Boolean del(int id){
        stuscoreService.delByScoreid(id);
        int i =classscoreService.deleteByPrimaryKey(id);
        if(i >0){
            return true;
        }
        return false;
    }


    /**
     * @param limit
     * @param page
     * @return
     * 获取数据
     */
    @RequestMapping("studata")
    @ResponseBody
    public JsonData studata(@Param("limit")int limit , @Param("page")int page,Integer scoreid){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(stuscoreService.getTotalRow(scoreid));
        jsonData.setData(stuscoreService.allPageClassScore(pager,scoreid));
        return jsonData;
    }

    @RequestMapping("stuupd")
    @ResponseBody
    public Boolean stuupd(Stuscore stuscore){
        int i = stuscoreService.updateByPrimaryKeySelective(stuscore);
        if(i >0){
            return true;
        }
        return false;
    }

}
