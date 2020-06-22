package com.ht.web.emp;

import com.ht.bean.emp.Chatrecord;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.Student;
import com.ht.service.emp.ChatrecordService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 健哥
 * @date 2020/6/16 14:38
 */
@Controller
@RequestMapping("chatrecord")
public class ChatRecordController {
    @Resource
    private ChatrecordService chatrecordService;

    @Resource
    private JsonData jsonData;


    //谈心记录数据
    @RequestMapping("chatrecorddata")
    @ResponseBody
    public JsonData chatrecorddata(@Param("limit")int limit , @Param("page")int page){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(chatrecordService.selchatcount());
        List<Chatrecord> list = chatrecordService.allPageChatrecord(pager);
        jsonData.setData(list);
        return jsonData;
    }

    //删除谈心记录
    @RequestMapping("delchatrecord")
    @ResponseBody
    public Integer delchatrecord(Integer id){
        Integer i = chatrecordService.deleteByPrimaryKey(id);
        return i;
    }

    //去到编辑谈心记录页面
    @RequestMapping("toeditchat")
    public String toeditchat(Integer chatid, Model model){
        List list = chatrecordService.selectByChatid(chatid);
        model.addAttribute("list",list);
        return "emp/editChatRecord";
    }

    //修改谈心记录
    @RequestMapping("editchat")
    @ResponseBody
    public Boolean editchat(Chatrecord chatrecord){
        chatrecordService.updateByPrimaryKeySelective(chatrecord);
        return true;
    }

    //去添加方法
    @RequestMapping("toaddchat")
    public String toaddchat(Model model){
        List<Student> list = chatrecordService.selectStudent();
        model.addAttribute("list",list);
        return "emp/addChatrecord";
    }

    @RequestMapping("addchat")
    @ResponseBody
    public Boolean addchat(Chatrecord chatrecord,HttpSession session){

        Boolean bool=null;
        Empinfo empinfo=(Empinfo)session.getAttribute("user");
        Integer empid = empinfo.getEmp_id();
        chatrecord.setTeacher(empid);
        chatrecord.setChatdate(new SimpleDateFormat("yyyy-MM-dd ").format(new Date()));
        int i=5-chatrecordService.selchatcountmonth(empid);
        System.out.println(i+"---"+empid+"****"+chatrecordService.selchatcountmonth(empid));
        if (i<=0){
            bool=false;
        }else {
            chatrecordService.insert(chatrecord);
            bool=true;
        }

        return bool;
    }
}
