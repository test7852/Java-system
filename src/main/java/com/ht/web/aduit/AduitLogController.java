package com.ht.web.aduit;

import com.ht.bean.aduit.Aduitlog;
import com.ht.bean.aduit.Aduitmodel;
import com.ht.bean.emp.Empinfo;
import com.ht.bean.file.Datadoc;
import com.ht.bean.json.JsonData;
import com.ht.service.aduit.AduitlogService;
import com.ht.service.aduit.AduitmodelService;
import com.ht.service.emp.EmpinfoService;
import com.ht.util.Contants;
import com.ht.util.Pager;
import com.ht.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 王金宝
 * @date 2020/6/16 9:26
 */
@Controller
@RequestMapping("aduitlog")
public class AduitLogController {
    @Resource
    private AduitlogService aduitlogservice;
    @Resource
    private EmpinfoService empinfoService;
    @Resource
    private AduitmodelService aduitmodelService;
    @Resource
    private JsonData jsonData;


    /**
     * @param limit
     * @param page
     * @return
     * 获取考核入录列表信息
     */
    @RequestMapping("listdata")
    @ResponseBody
    public JsonData depList(int limit ,int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(aduitlogservice.getTotalRow());
        List<Aduitlog> aduitlogs= aduitlogservice.allPageAduitlog(pager);
        for(Aduitlog aduitlog : aduitlogs){
            Aduitmodel aduitmodel = aduitmodelService.selectByPrimaryKey(aduitlog.getAduitmodelid());
            Empinfo emp = empinfoService.selectByPrimaryKey(aduitlog.getEmpid());
            if(aduitmodel != null){
                aduitlog.setAduitname(aduitmodel.getAduitname());
            }
            if(emp != null){
               aduitlog.setEmpname(emp.getEmp_name());
            }
        }
        jsonData.setData(aduitlogs);
        return jsonData;
    }




    /**
     * @param map
     * @return
     * 去考核指标添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Map map){
        map.put("models",aduitmodelService.allAduitmodel());
        return "aduit/aduitlogadd";
    }

    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Aduitlog aduitlog, String empname, HttpSession session) throws IOException {
        List<Empinfo> empinfos = empinfoService.empinfoByName(empname);
        if(empinfos.size() <= 0){
            return false;
        }
        Empinfo emp = (Empinfo) session.getAttribute("user");
        Aduitmodel aduitmodel = aduitmodelService.selectByPrimaryKey(aduitlog.getAduitmodelid());
        aduitlog.setScores(""+aduitmodel.getScores());
        aduitlog.setEmpid(empinfos.get(0).getEmp_id());
        aduitlog.setAuditperson(emp.getEmp_name());
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(new Date());
        aduitlog.setAuditdate(createdate);

        int b = aduitlogservice.insert(aduitlog);
        if(b>0){
            return true;
        }
        return false;
    }

    /**
     * @param map
     * @param id
     * @return
     * 去修改页面
     */
    @RequestMapping("toupd")
    public String toupd(Map map,Integer id){
        map.put("models",aduitmodelService.allAduitmodel());
        Aduitlog aduitlog = aduitlogservice.selectByPrimaryKey(id);
        map.put("aduitlog",aduitlog);
        map.put("emp",empinfoService.selectByPrimaryKey(aduitlog.getEmpid()));
        return "aduit/aduitlogupd";
    }
    /**
     * @param aduitlog
     * @return
     * 修改部门信息
     */
    @RequestMapping("upd")
    @ResponseBody
    public Boolean upd(Aduitlog aduitlog,String empname){
        List<Empinfo> empinfos = empinfoService.empinfoByName(empname);
        if(empinfos.size() <= 0){
            return false;
        }
        Aduitmodel aduitmodel = aduitmodelService.selectByPrimaryKey(aduitlog.getAduitmodelid());
        aduitlog.setScores(""+aduitmodel.getScores());
        aduitlog.setEmpid(empinfos.get(0).getEmp_id());

        int b = aduitlogservice.updateByPrimaryKeySelective(aduitlog);
        if(b>0){
            return true;
        }
        return false;

    }

    @RequestMapping("del")
    @ResponseBody
    public Boolean del(Integer id){
        int i = aduitlogservice.deleteByPrimaryKey(id);
        if(i>0){
            return true;
        }

        return false;
    }


    @RequestMapping("toupload")
    public String toupload(Map map,Integer id){
        map.put("id",id);
        return "aduit/upload";
    }

    @RequestMapping("upload")
    @ResponseBody
    public Boolean upload(MultipartFile file,Integer id) throws IOException {
        Aduitlog aduitlog = aduitlogservice.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        //获取String类型的时间
        String createdate = sdf.format(new Date());
        String url = Contants.PRO_FILE_SAVE_ADUIT+createdate;
        Datadoc datadoc = Utils.fileUpload(file,url);
        aduitlog.setImage(createdate+"/"+datadoc.getUrl());
        aduitlogservice.updateByPrimaryKeySelective(aduitlog);
        return true;
    }

    @RequestMapping("tolook")
    public String tolook(Map map,Integer id){
        map.put("log",aduitlogservice.selectByPrimaryKey(id));
        return "aduit/look";
    }

    @RequestMapping("look")
    @ResponseBody
    public Boolean look(MultipartFile file,Integer id) throws IOException {
        Aduitlog aduitlog = aduitlogservice.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        //获取String类型的时间
        String createdate = sdf.format(new Date());
        String url = Contants.PRO_FILE_SAVE_ADUIT+createdate;
        Datadoc datadoc = Utils.fileUpload(file,url);
        aduitlog.setImage(createdate+"/"+datadoc.getUrl());
        aduitlogservice.updateByPrimaryKeySelective(aduitlog);
        return true;
    }

}
