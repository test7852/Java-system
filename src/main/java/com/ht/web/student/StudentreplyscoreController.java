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
     * @param pager
     * @param map
     * @return
     * 分页
     */
    @RequestMapping("list")
    public String list(Pager pager, Map map){
        pager.page(studentreplyscoreService.getTotalRow());
        map.put("",studentreplyscoreService.allPageStuRecord(pager));
        return "";
    }

    /**
     * @param studentreplyscore
     * @return
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Studentreplyscore studentreplyscore){
        studentreplyscoreService.insert(studentreplyscore);
        return "";
    }

    /**
     * @param studentreplyscore
     * @return
     * 添加学生信息
     */
    @RequestMapping("add")
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
    @RequestMapping("update")
    @ResponseBody
    public Integer update(Studentreplyscore studentreplyscore){
        System.out.println(studentreplyscore.toString());
        int selective = studentreplyscoreService.updateByPrimaryKeySelective(studentreplyscore);
        return selective;
    }

    /**
     * @param replyid
     * @return
     * 删除学生
     */
    @RequestMapping("del")
    public String del(int replyid){
// (待删除)       studentreplyscoreService.deleteByPrimaryKey(replyid);
        return "redirect:reply/replyUi";
    }
}
