package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Major;
import com.ht.service.emp.DepService;
import com.ht.service.student.DeptService;
import com.ht.service.student.MajorService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 王钟华
 * @date 2020年6月15日16:12:25
 */
@Controller
@RequestMapping("major")
public class MajorController {
    @Resource
    private JsonData jsonData;
    @Resource
    private MajorService majorService;
    @Resource
    private DeptService deptService;


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
        jsonData.setCount(majorService.selCount());
        jsonData.setData(majorService.sybase(pager));
        return jsonData;
    }

    /**
     * @param major
     * @return
     * 修改职位信息
     */
    @RequestMapping("update")
    @ResponseBody
    public Boolean  update(Major major){
        Major major1 = majorService.selectByName(major.getMajorname());
        if(major1 == null){
            majorService.updateByPrimaryKeySelective(major);
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
        int b = majorService.deleteByPrimaryKey(id);
        if(b>0){
            return true;
        }
        return false;
    }

    /**
     * @param major
     * @return
     * 添加职位
     */
    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Major major){
        Major major1 = majorService.selectByName(major.getMajorname());
        if(major1 == null){
            majorService.insert(major);
            return true;
        }
        return false;
    }


    @RequestMapping("list")
    public String list(){
        return "/student/major";
    }


    @RequestMapping("toAdd")
    public String toAdd(Map map){
//        List l = deptService();
//        map.put("deps",l);
        return "/student/majoradd";
    }
}
