package com.ht.web.emp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 半口香甜吴一玄
 */
@Controller
@RequestMapping("option")
public class empoptionController {

    //word界面 员工界面
    @RequestMapping("toworkadd")
    public String word(Integer id){
        return "empoption/work";
    }

    //员工新增 与 修改
    @RequestMapping("workadd")
    public String toadd(Integer id){
        //两个操作同一使用这个方法和界面 新增不赋值 修改则赋值
        return "empoption/workadd";
    }

    //教育背景
    @RequestMapping("toeducationadd")
    public String toeducation(){
        return "empoption/educational";
    }

    @RequestMapping("educationadd")
    public String educational(){
        return "empoption/addeducational";
    }

    //家庭联系信息
    @RequestMapping("tolink")
    public String tolink(){
        return "empoption/linkman";
    }

    @RequestMapping("linkadd")
    public String link(){
        return "empoption/linkmanadd";
    }

}
