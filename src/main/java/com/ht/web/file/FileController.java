package com.ht.web.file;

import com.ht.bean.emp.Empinfo;
import com.ht.bean.file.Datadoc;
import com.ht.bean.json.JsonData;
import com.ht.service.file.DatadocService;
import com.ht.service.student.StudentclassService;
import com.ht.util.Contants;
import com.ht.util.Pager;
import com.ht.util.Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author 王钟华
 * @date 2020-06-09 10:15
 */
@Controller
@RequestMapping("dataDoc")
public class FileController {

    @Resource
    private JsonData jsonData;
    @Resource
    private DatadocService datadocService;

    @RequestMapping("add")
    public String add(MultipartFile file,HttpServletRequest request) throws IOException {
        Empinfo e = (Empinfo) request.getSession().getAttribute("user");
        System.out.println(e);
        Datadoc datadoc = Utils.fileUpload(file,Contants.PRO_FILE_SAVE_PATH);
        datadocService.insert(datadoc);
        return "redirect:/dataDoc/toAdd";
    }
    @RequestMapping("toAdd")
    public String add(){
        return "file/addFile";
    }

    @RequestMapping("data")
    @ResponseBody
    public JsonData data(@Param("limit")int limit , @Param("page")int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(datadocService.selCount());
        jsonData.setData(datadocService.sybase(pager));
        return jsonData;
    }


    /**
     * @return
     * 去员工资料表
     */
    @RequestMapping("list")
    public String list(){
        return "file/Datadoc";
    }


    @RequestMapping("del")
    public String del(@Param("id") Integer id){
        datadocService.deleteByPrimaryKey(id);
        return "redirect:/dataDoc/list";
    }


    //实现Spring Boot 的文件下载功能，映射网址为/download
    @RequestMapping("/download")
    @ResponseBody
    public void downloadFile(HttpServletRequest request,
                               HttpServletResponse response,
                               Integer id) throws UnsupportedEncodingException {


        Datadoc datadoc = datadocService.selectByPrimaryKey(id);
        String fileName = datadoc.getUrl();
//         如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = Contants.PRO_FILE_SAVE_PATH;
            File file = new File(realPath, fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("下载成功!");
                }
                catch (Exception e) {
                    System.out.println("下载失败！");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return;
    }
}
