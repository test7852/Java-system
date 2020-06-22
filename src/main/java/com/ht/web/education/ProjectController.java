package com.ht.web.education;

import com.ht.bean.education.Project;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Dept;
import com.ht.service.education.ProjectService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author roger
 * @date 2020/6/22 15:26
 */
@Controller
@RequestMapping("project")
public class ProjectController {

    @Resource
    private ProjectService ps;

    @Resource
    private JsonData jsonData;

    //去到项目界面
    @RequestMapping("toproject")
    public String toproject(){
        return "education/project";
    }

    @RequestMapping("projectdata")
    @ResponseBody
    public JsonData projectdata(@Param("limit")int limit , @Param("page")int page){
        Pager pager=new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(ps.selprocount());
        jsonData.setData(ps.allProject(pager));
        return jsonData;
    }

    @RequestMapping("del")
    @ResponseBody
    public Integer del(Integer id){
        Integer i = ps.deleteByPrimaryKey(id);
        return i;
    }

    @RequestMapping("update")
    @ResponseBody
    public Boolean update(Project project,String projectName){
        Project pro = ps.selByObjName(projectName);
        if(pro == null){
            ps.updateByPrimaryKeySelective(project);
            return true;
        }
        return false;
    }
}
