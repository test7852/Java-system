package com.ht.web.education;

import com.ht.bean.education.Classreply;
import com.ht.bean.education.Stureply;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Student;
import com.ht.service.education.*;
import com.ht.service.student.StudentService;
import com.ht.service.student.StudentclassService;
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
 * @author 王金宝
 * @date 2020/6/20 8:32
 */
@Controller
@RequestMapping("classreply")
public class ClassReplyController {
    @Resource
    private StureplyService stureplyService;
    @Resource
    private ClassreplyService classreplyService;
    @Resource
    private StudentclassService studentclassService;

    @Resource
    private StudentService studentService;
    @Resource
    private ProjectService projectService;
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
        jsonData.setCount(classreplyService.getTotalRow());
        jsonData.setData(classreplyService.allPageClassReply(pager));
        return jsonData;
    }

    /**
     * @param map
     * @return
     * 去班级成绩添加页面
     */
    @RequestMapping("toadd")
    public String cedutoadd(Map map){
        map.put("projects",projectService.allProject());
        map.put("calsss",studentclassService.selList());
        return "education/classreplyadd";
    }


    /**
     * @param classreply
     * @param session
     * @return
     * 添加
     */
    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Classreply classreply, HttpSession session){

        Empinfo emp = (Empinfo) session.getAttribute("user");
        classreply.setEmpid(emp.getEmp_id());
        int i =classreplyService.insert(classreply);
        Integer id = classreplyService.getId();
        List<Student> list =studentService.allStuClazz(classreply.getClassid());
        for (Student student:list){
            Stureply stureply = new Stureply();
            stureply.setReplyid(id);
            stureply.setStuid(student.getStudid());
            i=stureplyService.insert(stureply);
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
    @RequestMapping("toupd")
    public String toupd(Integer id,Map map){
        map.put("classreply",classreplyService.selectByPrimaryKey(id));
        map.put("projects",projectService.allProject());
        map.put("calsss",studentclassService.selList());
        return "education/classreplyupd";
    }


    @RequestMapping("look")
    public String modellist(Integer replyid,Map map){
        map.put("replyid",replyid);
        return "education/stureplylist";
    }
    /**
     * @param classreply
     * @return
     * 修改
     */
    @RequestMapping("upd")
    @ResponseBody
    public Boolean upd(Classreply classreply){
        Classreply classreply1= classreplyService.selectByPrimaryKey(classreply.getReplyid());

        if(classreply.getClassid() != classreply1.getClassid() ){
            stureplyService.delByStuReply(classreply.getReplyid());
            List<Student> list =studentService.allStuClazz(classreply.getClassid());
            for (Student student:list){
                Stureply stureply = new Stureply();
                stureply.setReplyid(classreply.getReplyid());
                stureply.setStuid(student.getStudid());
                stureplyService.insert(stureply);
            }
        }
        int i =classreplyService.updateByPrimaryKeySelective(classreply);
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
    @RequestMapping("del")
    @ResponseBody
    public Boolean del(int id){
        stureplyService.delByStuReply(id);
        int i =classreplyService.deleteByPrimaryKey(id);
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
    public JsonData studata(@Param("limit")int limit , @Param("page")int page,Integer replyid){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(stureplyService.getTotalRow(replyid));
        jsonData.setData(stureplyService.allPageClassReply(pager,replyid));
        return jsonData;
    }

    @RequestMapping("stuupd")
    @ResponseBody
    public Boolean stuupd(Stureply stureply){
//        if(stureply.getScore1() == null){
//            stureply.setScore1((double)0);
//        }
//        if(stureply.getScore2() == null){
//            stureply.setScore2((double)0);
//        }
//        if(stureply.getScore3() == null){
//            stureply.setScore3((double)0);
//        }
//        if(stureply.getScore4() == null){
//            stureply.setScore4((double)0);
//        }
//        if(stureply.getScore5() == null){
//            stureply.setScore5((double)0);
//        }
//        if(stureply.getScore6() == null){
//            stureply.setScore6((double)0);
//        }

        double sum =stureply.getScore1()+stureply.getScore2()+
                    stureply.getScore3()+stureply.getScore4()+
                    stureply.getScore5()+stureply.getScore6();
        stureply.setScore7(sum);
        int i = stureplyService.updateByPrimaryKeySelective(stureply);
        if(i >0){
            return true;
        }
        return false;
    }

}
