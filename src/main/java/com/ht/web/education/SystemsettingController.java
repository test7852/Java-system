package com.ht.web.education;

import com.ht.bean.education.Classtype;
import com.ht.bean.education.Term;
import com.ht.bean.json.JsonData;
import com.ht.service.education.ClasstypeService;
import com.ht.service.education.TermService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @半口香甜吴一玄
 * 2020/6/22
 */

@Controller
@RequestMapping("system")
public class SystemsettingController {

    @Resource
    JsonData jsonData;

    @Resource
    ClasstypeService classtypeService;

    @Resource
    TermService termService;

    //链接班级类别页面
    @RequestMapping("toclasstypelist")
    public String classtypelist(){
        return "systemsetting/classtype";
    }
    //班级类别表格数据
    @RequestMapping("classtypedate")
    @ResponseBody
    public JsonData classtypedate(@Param("limit")Integer limit,@Param("page")Integer page){
        Pager pager=new Pager(page,limit);
        jsonData.setData(classtypeService.classtpedata(pager));
        jsonData.setCount(classtypeService.getclasstypeRow());
        return jsonData;
    }

    //班级类别添加
    @RequestMapping("classtypeadd")
    @ResponseBody
    public Integer classtypeadd(Classtype classtype){
        List<Classtype> list =classtypeService.alldata();
        //因为数据库表格ID列自增 所以只填一个参数 班级名
        //循环判断是否ID或名字重复
        for(Classtype classtype1:list){
            if(classtype1.getClasstypename().equals(classtype.getClasstypename())){
                return 0;
            }
        }
        Integer update=classtypeService.insert(classtype);
        return update;
    }

    //删除
    @RequestMapping("classtypedelete")
    @ResponseBody
    public int classtypedelete(@Param("id")Integer id) {
        Integer delete = classtypeService.deleteByPrimaryKey(id);
        return delete;
    }

    //编辑
    @RequestMapping("classtypeupdate")
    @ResponseBody
    public Integer classtypeupdate(Classtype classtype){
        Integer update = classtypeService.updateByPrimaryKey(classtype);
        return update;
    }

    /**
     * 学期设置
     */
    //链接到学期界面
    @RequestMapping("totermlist")
    public String totermlist(){
        return "systemsetting/term";
    }

    //学期表格数据
    @RequestMapping("tremdata")
    @ResponseBody
    public JsonData tremdata(@Param("limit")Integer limit,@Param("page")Integer page){
        Pager pager=new Pager(page,limit);
        jsonData.setData(termService.Termpaging(pager));
        jsonData.setCount(termService.gettermRow());
        return jsonData;
    }

    //学期表格新增
    @RequestMapping("termadd")
    @ResponseBody
    public Integer termadd(Term term){
        List<Term> list =termService.allTerm();
        //因为数据库表格ID列自增 所以只填一个参数
        //循环判断是否ID或名字重复
        for(Term term1:list){
            if(term1.getTermname().equals(term.getTermname())){
                return 0;
            }
        }
        Integer insert= termService.insert(term);
        return insert;
    }

    //学期表格删除
    @RequestMapping("termdelete")
    @ResponseBody
    public Integer termdelete(Integer id){
        Integer delete= termService.deleteByPrimaryKey(id);
        return delete;
    }

    //学期表格修改
    @RequestMapping("termupdate")
    @ResponseBody
    public Integer termupdate(Term term){
        Integer update= termService.updateByPrimaryKey(term);
        return update;
    }

}
