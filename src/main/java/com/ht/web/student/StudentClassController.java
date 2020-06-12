package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Student;
import com.ht.bean.student.Studentclass;
import com.ht.service.student.StudentclassService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
        //使用的时候放开注释
        int i = studentclassService.insertSelective(studentclass);
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
//(待删除)       studentclassService.deleteByPrimaryKey(id);
        return "redirect:studentClass/list";
    }

    /**
     * @param studentclass
     * @return 修改
     */
    @RequestMapping("update")
    @ResponseBody
    public Integer updata(Studentclass studentclass){
        System.out.println("studentclass = " + studentclass.toString());
        int updatacurr = studentclassService.updateByPrimaryKeySelective(studentclass);
        System.out.println(updatacurr);
        return updatacurr;
    }
}
