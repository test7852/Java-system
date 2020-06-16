package com.ht.web.student;

import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Replyscore;
import com.ht.bean.student.Student;
import com.ht.bean.student.Studentreplyscore;
import com.ht.service.student.ReplyscoreService;
import com.ht.service.student.StudentService;
import com.ht.service.student.StudentreplyscoreService;
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
 * 学生答辩管理
 */
@Controller
@RequestMapping("reply")
public class StudentreplyscoreController {
    @Resource
    private StudentreplyscoreService studentreplyscoreService;// 学生答辩
    @Resource
    private StudentService studentService;//学生
    @Resource
    private ReplyscoreService replyscoreService;//学生答辩成绩中间表
    //去到列表
    @RequestMapping("replyUi")
    public String stusclistUi(){
        return "student/replylist";
    }

    //加载数据
    @Resource
    private JsonData jsonData;

    @RequestMapping("replydata")
    @ResponseBody
    public JsonData replydata(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(studentreplyscoreService.getTotalRow());
        jsonData.setCode(0);
        jsonData.setData(studentreplyscoreService.allPageStuRecord(pager));
        return jsonData;
    }


    /**
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Map map){
        List<Student> studentList= studentService.allStu();
        map.put("student", studentList);
        return "student/replyadd";
    }

    /**
     * @param studentreplyscore
     * @return
     * 添加学生信息
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(Studentreplyscore studentreplyscore,HttpSession session){
        Empinfo empinfo= (Empinfo)session.getAttribute("user");
        studentreplyscore.setEmpid(empinfo.getEmp_id());
        studentreplyscoreService.insert(studentreplyscore);
        System.out.println("studentreplyscore添加："+studentreplyscore);
        Student stu=studentService.selectByPrimaryKey(studentreplyscore.getStudentid());
        Replyscore replyscore =new Replyscore();
        replyscore.setEmpid(studentreplyscore.getStudentid());
        replyscore.setClazz(String.valueOf(stu.getClazz()));
        replyscore.setReplyid(studentreplyscore.getReplyid());
        replyscoreService.insert(replyscore);
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
        map.put("",studentreplyscoreService.selectByPrimaryKey(stuid));
        return "";
    }

    /**
     * @param studentreplyscore
     * @return
     * 修改学生信息
     */
    @RequestMapping("upd")
    @ResponseBody
    public String upd(Studentreplyscore studentreplyscore){
        System.out.println(studentreplyscore.toString()+"55");
        studentreplyscoreService.updateByPrimaryKey(studentreplyscore);
        return "";
    }

    /**
     * @param replyid
     * @return
     * 删除学生
     */
    @RequestMapping("del")
    public String del(int replyid){
        studentreplyscoreService.deleteByPrimaryKey(replyid);
        return "redirect:reply/replyUi";
    }
}
