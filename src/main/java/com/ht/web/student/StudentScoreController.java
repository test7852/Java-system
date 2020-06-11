package com.ht.web.student;

import com.ht.bean.json.JsonData;
import com.ht.bean.student.StudentScore;
import com.ht.service.student.StudentScoreService;
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
 * 学生成绩
 */
@Controller
@RequestMapping("score")
public class StudentScoreController {
    @Resource
    private StudentScoreService studentScoreService;
//去到列表+
    @RequestMapping("scorelistUi")
    public String scorelistUi(){
        return "student/scorelist";
    }
    //加载数据
    @Resource
    private JsonData jsonData;

    @RequestMapping("scoredata")
    @ResponseBody
    public JsonData empdata(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(studentScoreService.getTotalRow());
        jsonData.setCode(0);
        jsonData.setData(studentScoreService.allPageStuScore(pager));
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
        pager.page(studentScoreService.getTotalRow());
        map.put("",studentScoreService.allPageStuScore(pager));
        return "";
    }

    /**
     * @param studentScore
     * @return
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(StudentScore studentScore){
        studentScoreService.insert(studentScore);
        return "";
    }

    /**
     * @param studentScore
     * @return
     * 添加学生信息
     */
    @RequestMapping("add")
    public String add(StudentScore studentScore){
        studentScoreService.insert(studentScore);
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
        map.put("",studentScoreService.selectByPrimaryKey(stuid));
        return "";
    }

    /**
     * @param studentScore
     * @return
     * 修改学生信息
     */
    @RequestMapping("upd")
    public String upd(StudentScore studentScore){
        studentScoreService.updateByPrimaryKey(studentScore);
        return "";
    }

    /**
     * @param id
     * @return
     * 删除学生
     */
    @RequestMapping("del")
    public String del(int id){
        System.out.println(id+"    scoreid");
        studentScoreService.deleteByPrimaryKey(id);
        return "redirect:score/scorelistUi";
    }
}
