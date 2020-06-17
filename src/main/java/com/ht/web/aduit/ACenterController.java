package com.ht.web.aduit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrq
 * @date 2020/6/10 19:38
 * 中心跳转
 */
@Controller
@RequestMapping("skip")
public class ACenterController {

    //去到考核指标管理页面
    @RequestMapping("aduitmodelList")
    public String postlist(){
        return "aduit/aduitmodelList";
    }

}
