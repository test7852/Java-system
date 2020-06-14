package com.ht.web.education;

import com.ht.bean.education.Course;
import com.ht.bean.education.Trial;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.service.education.TrialService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author chun
 * @date 2020/6/12 10:48
 */
@Controller
@RequestMapping("/trial")
public class TroalController {

    @Resource
    private JsonData jsonData;

    @Resource
    private TrialService trialService;

    //去到试讲培训界面
    @RequestMapping("/triallist")
    public String courselist(){
        return "education/troallist";
    }

    //试讲培训数据
    @RequestMapping("/trialdata")
    @ResponseBody
    public JsonData jsonData(@Param("limit")int limit , @Param("page")int page ){
        Pager pager = new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(trialService.selTrial());
        jsonData.setData(trialService.selByPage(pager));
        return jsonData;
    }

    //试讲培训 根据id删除
    @RequestMapping("/trialdel")
    @ResponseBody
    public Integer trialdel(Integer trialid){
        int i = trialService.deleteByPrimaryKey(trialid);
        System.out.println("删除的id"+trialid);
        return i;
    }

    //试讲培训 根据id修改
    @RequestMapping("/trialupd")
    @ResponseBody
    public Integer trialupd(Trial trial){
        int i = trialService.updateByPrimaryKey(trial);
        System.out.println("修改:"+trial);
        return i;
    }

    //试讲培训 去新增界面
    @RequestMapping("/trialtoadd")
    public String trialtoadd(Map map){
        List<Course> coulist = trialService.Coulist();//查询课程管理表
        List<Empinfo> emplist = trialService.Emplist();//查询emp表
        map.put("clist",coulist);
        map.put("elist",emplist);
        return "education/troaladd";
    }

    //试讲培训 进行修改
    @RequestMapping("/trialadd")
    @ResponseBody
    public Integer trialadd(Trial trial){
        System.out.println("新增:"+trial);
        int insert = trialService.insert(trial);
        return insert;
    }

}
