package com.ht.web.aduit;

import com.ht.bean.aduit.Maintain;
import com.ht.bean.emp.Dep;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Studentclass;
import com.ht.service.aduit.MaintainService;
import com.ht.util.Contants;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chun
 * @date 2020/6/19 8:30
 */
@Controller
@RequestMapping("/main")
public class MaintainController {

    @Resource
    private MaintainService maintainService;

    @Resource
    private JsonData jsonData;

    //去到list
    @RequestMapping("/list")
    public String list(){
        return "aduit/mainlist";
    }

    //去到id list
    @RequestMapping("/idlist")
    public String idlist(){
        return "aduit/mainidlist";
    }

    //id  去add界面
    @RequestMapping("/idtoadd")
    public String idtoadd(Map map){
        List<Studentclass> selclass = maintainService.selclass();//查询班级
        List<Dep> seldep = maintainService.seldep();//查询部门
        map.put("clist",selclass);
        map.put("dlist",seldep);
        return "aduit/mainadd";
    }

    //数据
    @RequestMapping("/data")
    @ResponseBody
    public JsonData jsonData(@Param("limit") int limit,@Param("page") int page,Maintain maintain){
        Pager pager = new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(maintainService.selMain());
        jsonData.setData(maintainService.mhmain(pager,maintain));
        System.out.println(maintainService.mhmain(pager,maintain));
//        System.out.println("数据"+jsonData);
        return jsonData;
    }

    //id数据
    @RequestMapping("/iddata")
    @ResponseBody
    public JsonData idjsonData(@Param("limit") int limit, @Param("page") int page, HttpSession session,Maintain maintain){
        System.out.println(maintain+"模糊提交数据");
        //获取session
        Empinfo user = (Empinfo) session.getAttribute("user");
        Integer id = user.getEmp_id();

        Pager pager = new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(maintainService.byid(id));
        jsonData.setData(maintainService.byidpage(id,pager,maintain));
        return jsonData;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public Integer del(Integer wxid){
        System.out.println("要删除的id"+wxid);
        int i = maintainService.deleteByPrimaryKey(wxid);
        return i;
    }

    //修改状态
    @RequestMapping("/set")
    @ResponseBody
    public Boolean set(Maintain maintain){
        if(maintain.getStatus() == Contants.STATUS_SU){//状态等于1  未修好
            maintain.setStatus(Contants.STATUS_SW);//状态改成已修好
            maintain.setEndtime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//设置结束时间
        }else {
            maintain.setStatus(Contants.STATUS_SU);//状态改成未修好
            maintain.setEndtime(" ");//把结束时间清空
        }
        maintainService.updateByPrimaryKeySelective(maintain);
        return true;
    }

    //新增
    @RequestMapping("/add")
    @ResponseBody
    public Integer add(Maintain maintain){
        maintain.setStarttime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//设置开始时间
        maintain.setStatus(1);//设置开始状态1
        int insert = maintainService.insert(maintain);
        return insert;
    }

    //查看
    @RequestMapping("/maintoupd")
    public String maintoupd(Integer wxid,Map map){
        Maintain maintain = maintainService.selectByPrimaryKey(wxid);
        map.put("list",maintain);
        return "aduit/mainupd";
    }

    //修改
    @RequestMapping("/upd")
    @ResponseBody
    public Integer upd(Maintain maintain){
        System.out.println("说明"+maintain);
        int i = maintainService.updateByPrimaryKeySelective(maintain);
        return i;
    }

    //id去修改
    @RequestMapping("/maintoupdid")
    public String mainupdid(Integer wxid,Map map){
        List<Studentclass> selclass = maintainService.selclass();//查询班级
        List<Dep> seldep = maintainService.seldep();//查询部门
        map.put("clist",selclass);
        map.put("dlist",seldep);
        Maintain maintain = maintainService.selectByPrimaryKey(wxid);
        map.put("list",maintain);
        return "aduit/mainidupd";
    }

    //id修改
    @RequestMapping("/idupd")
    @ResponseBody
    public Integer idupd(Maintain maintain){
        System.out.println("修改"+maintain);
        int i = maintainService.updateByPrimaryKeySelective(maintain);
        return i;
    }

    //id新增
    @RequestMapping("/idadd")
    @ResponseBody
    public Integer idadd(Maintain maintain,HttpSession session){
        System.out.println("id新增"+maintain);
        //设置开始时间
        maintain.setStarttime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //设置开始状态 1
        maintain.setStatus(1);
        //设置user
        Empinfo user = (Empinfo) session.getAttribute("user");
        Integer id = user.getEmp_id();
        maintain.setEmp_id(id);
        //新增方法
        int i = maintainService.insertSelective(maintain);
        return i;
    }
}
