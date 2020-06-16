package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Studentfall;
import com.ht.service.emp.PostService;
import com.ht.service.student.StudentfallService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 王钟华
 * @date 2020年6月15日16:12:25
 */
@Controller
@RequestMapping("studentFall")
public class StudentFallController {
    @Resource
    private JsonData jsonData;
    @Resource
    private StudentfallService studentfallService;


    /**
     * @param limit
     * @param page
     * @return
     * 获取职位信息
     */
    @RequestMapping("data")
    @ResponseBody
    public JsonData  data(int limit,int page){

        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(studentfallService.getTotalRow());
        jsonData.setData(studentfallService.allPagePost(pager));
        return jsonData;
    }

    /**
     * @param studentfall
     * @return
     * 修改职位信息
     */
    @RequestMapping("update")
    @ResponseBody
    public Boolean  update(Studentfall studentfall){
        Studentfall post1 = studentfallService.selectByName(studentfall.getLevel());
        if(post1 == null){
            studentfallService.updateByPrimaryKeySelective(studentfall);
            return true;
        }
        return false;
    }

    /**
     * @param id
     * @return
     * 删除职位
     */
    @RequestMapping("del")
    @ResponseBody
    public Boolean del(Integer id){
        int b = studentfallService.deleteByPrimaryKey(id);
        if(b>0){
            return true;
        }
        return false;
    }

    /**
     * @param studentfall
     * @return
     * 添加职位
     */
    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Studentfall studentfall){
        Studentfall post1 = studentfallService.selectByName(studentfall.getLevel());
        if(post1 == null){
            studentfallService.insert(studentfall);
            return true;
        }
        return false;
    }


    @RequestMapping("list")
    public String list(){
        return "/student/studentfall";
    }


    @RequestMapping("toAdd")
    public String toAdd(){
        return "/student/studentfalladd";
    }
}
