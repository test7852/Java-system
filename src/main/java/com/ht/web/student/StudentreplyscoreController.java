package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.Studentreplyscore;
import com.ht.service.student.StudentreplyscoreService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author xmf
 * @date 2020/6/10 14:35
 * 学生答辩管理
 */
@Controller
@RequestMapping("reply")
public class StudentreplyscoreController {
    @Resource
    private StudentreplyscoreService studentreplyscoreService;
    //去到列表
    @RequestMapping("replyUi")
    public String stusclistUi(){
        return "student/replylist";
    }
    //加载数据
    @Resource
    private JsonData jsonData;

    @RequestMapping("replydata")
    @ResponseBody
    public JsonData replydata(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(studentreplyscoreService.getTotalRow());
        jsonData.setCode(0);
        jsonData.setData(studentreplyscoreService.allPageStuRecord(pager));
        return jsonData;
    }


    /**
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(){
        return "student/replyadd";
    }

    /**
     * @param studentreplyscore
     * @return
     * 添加学生信息
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(Studentreplyscore studentreplyscore){
        studentreplyscoreService.insert(studentreplyscore);
        return "";
    }

    /**
     * @param stuid
     * @param map
     * @return
     * 去修改页面
     */
    @RequestMapping("toupd")
    public String toupd(int stuid,Map map){
        map.put("",studentreplyscoreService.selectByPrimaryKey(stuid));
        return "";
    }

    /**
     * @param studentreplyscore
     * @return
     * 修改学生信息
     */
    @RequestMapping("upd")
    @ResponseBody
    public String upd(Studentreplyscore studentreplyscore){
        System.out.println(studentreplyscore.toString()+"55");
        studentreplyscoreService.updateByPrimaryKey(studentreplyscore);
        return "";
    }

    /**
     * @param replyid
     * @return
     * 删除学生
     */
    @RequestMapping("del")
    public String del(int replyid){
        studentreplyscoreService.deleteByPrimaryKey(replyid);
        return "redirect:reply/replyUi";
    }
}
