package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Student;
import com.ht.bean.student.Studentclass;
import com.ht.bean.student.Studentfloor;
import com.ht.service.student.StudentclassService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王钟华
 * @date 2020-06-10 10:53
 */
@Controller
@RequestMapping("studentClass")
public class StudentClassController {

    @Resource
    private JsonData jsonData;
    @Resource
    private StudentclassService studentclassService;


    @RequestMapping("data")
    @ResponseBody
    public JsonData data(@Param("limit")int limit , @Param("page")int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(studentclassService.selCount());
        jsonData.setData(studentclassService.sybase(pager));
        return jsonData;
    }


    /**
     * @return
     * 去班级添加
     */
    @RequestMapping("/toadd")
    public String toadd() {

        return "student/studentClassAdd";
    }

    /**
     * @param studentclass
     * @return
     * 添加班级
     */
    @RequestMapping("add")
    public Integer add(Studentclass studentclass){
        List<Studentclass> list = studentclassService.selList();
        for (Studentclass studentclass1:list) {
            if (studentclass.getClassname().equals(studentclass1.getClassname()) || studentclass1.getClassname()==studentclass.getClassname()
            || studentclass.getClassno().equals(studentclass1.getClassno()) || studentclass1.getClassno()==studentclass.getClassno()){
                return 0;
            }
        }
        Integer i = studentclassService.insertSelective(studentclass);
        return i;
    }

    /**
     * @return
     * 去班级页面
     */
    @RequestMapping("list")
    public String list(){
        return "student/studentClass";
    }



    @RequestMapping("del")
    public String del(@Param("id") Integer id){
        System.out.println("id = " + id);
       studentclassService.deleteByPrimaryKey(id);
        return "redirect:studentClass/list";
    }

    /**
     * @param studentclass
     * @return 修改
     */
    @RequestMapping("update")
    @ResponseBody
    public Integer updata(Studentclass studentclass) {
        List<Studentclass> list = studentclassService.selList();
        for (Studentclass studentclass1 : list) {
            if (studentclass.getClassname().equals(studentclass1.getClassname()) || studentclass1.getClassname() == studentclass.getClassname()
                    || studentclass.getClassno().equals(studentclass1.getClassno()) || studentclass1.getClassno() == studentclass.getClassno()) {
                return 0;
            }
        }
        Integer i = studentclassService.updateByPrimaryKeySelective(studentclass);
        return i;
    }
}
