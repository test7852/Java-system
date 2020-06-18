package com.ht.web.aduit;

import com.ht.bean.aduit.Equipmentwxgl;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Dept;
import com.ht.bean.student.Student;
import com.ht.bean.student.Studentclass;
import com.ht.service.aduit.EquipmentwxglService;
import com.ht.util.Contants;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chun
 * @date 2020/6/17 8:12
 */
@Controller
@RequestMapping("/wxgl")
public class EquipmentwxglController {

    @Resource
    private EquipmentwxglService equipmentwxglService;

    @Resource
    private JsonData jsonData;

    //去维修管理界面
    @RequestMapping("/equiwxgllist")
    public String equiwxgllist(){
        return "aduit/equiwxgllist";
    }

    //前台数据接口获取数据
    @RequestMapping("/equiwxgldata")
    @ResponseBody
    public JsonData jsonData(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(equipmentwxglService.selEqui());
        jsonData.setData(equipmentwxglService.selByPage(pager));
        return jsonData;
    }

    //删除
    @RequestMapping("/wxgldel")
    @ResponseBody
    public Integer wxgldel(Integer wxid){
        System.out.println(wxid);
        int i = equipmentwxglService.deleteByPrimaryKey(wxid);
        return i;
    }

    //修改状态 前台1==状态1就修改2
    @RequestMapping("set")
    @ResponseBody
    public Boolean set(Equipmentwxgl equipmentwxgl){
        if (equipmentwxgl.getStatus() == Contants.STATUS_SU){
            equipmentwxgl.setStatus(Contants.STATUS_SW);
        }else {
            equipmentwxgl.setStatus(Contants.STATUS_SU);
        }
        //设置结束时间
        equipmentwxgl.setEndtime(new SimpleDateFormat("yyyy-MM-dd ").format(new Date()));
        equipmentwxglService.updateByPrimaryKeySelective(equipmentwxgl);
        return true;
    }

    //去申请界面
    @RequestMapping("/sqlist")
    public String sqlist(Map map){
//        List<Student> selstu = equipmentwxglService.selstu();//查询学生
//        List<Studentclass> selclass = equipmentwxglService.selclass();//查询班级
//        List<Dept> seldept = equipmentwxglService.seldept();//查询系
//        map.put("selstu",selstu);
//        map.put("selclass",selclass);
//        map.put("seldept",seldept);
        return "aduit/equiadd";
    }

    //申请新增
    @RequestMapping("/sqadd")
    @ResponseBody
    public Integer sqadd(Equipmentwxgl equipmentwxgl){
        System.out.println("对象"+equipmentwxgl);
        //设置开始状态  为修好
        equipmentwxgl.setStatus(1);
        //设置开始时间
        equipmentwxgl.setStarttime(new SimpleDateFormat("yyyy-MM-dd ").format(new Date()));
        int insert = equipmentwxglService.insert(equipmentwxgl);
        return insert;
    }
}
