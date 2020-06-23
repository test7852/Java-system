package com.ht.web.file;


import com.ht.bean.json.JsonData;
import com.ht.util.Pager;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("flow")
public class FlowController {
    @Resource
    private JsonData jsonData;

    @Resource
    private ProcessEngine processEngine;
    @Resource
    private TaskService taskService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private HistoryService historyService;
    @Resource
    private RepositoryService repositoryService;


    /**
     * @return
     * 去流程管理页面
     */
    @RequestMapping("list")
    public String list(Map map){

        List<ProcessDefinition> list = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                .createProcessDefinitionQuery()//创建一个流程定义查询
                .orderByProcessDefinitionVersion().desc()//按照版本的升序排列
                .list();//返回一个集合列表，封装流程定义
        map.put("list",list);
        System.out.println(list.size());
        return "file/flowList";
    }




    /**
     * @return
     * 去上传流程页面
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "file/addFlow";
    }

    @RequestMapping("/delProcessDefinition")
    public String delProcessDefinition(String did){
        repositoryService.deleteDeployment(did,true);
        return "redirect:/flow/list";
    }

    //发布流程
    @RequestMapping("/uploadProcess")
    public String uploadProcess(MultipartFile multipartFile){
        try {
            //创建一个临时文件
            File file = File.createTempFile("tmp",null);
            //将MultipartFile装换成IO流的File
            multipartFile.transferTo(file);
            //使用Zip输入流发布流程定义文件（设置上传文件类型）
            Deployment deployment = repositoryService.createDeployment().addZipInputStream(new ZipInputStream(new FileInputStream(file))).deploy();
            System.out.println("发布ID "+deployment.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/flow/list";
    }




    /**
     * 下载流程图
     */
    @RequestMapping("/toExport")
    public String toExport(String id,HttpServletResponse resp){
        try {

            id = new String(id.getBytes("iso8859-1"),"utf-8");
            System.out.println("id = " + id);

            //设置response对象的头参数，attachment就是附件，filename=文件名称
            resp.setHeader("Content-disposition","attachment;filename=" +id+".zip" );
            //下载的文件类型是zip文件
            resp.setContentType("application/x-zip-compressed");

            //----------------------------------------------------------------------------


            //流程定义对象
            ProcessDefinition processDefinition = repositoryService
                    .createProcessDefinitionQuery()
                    .processDefinitionId(id).singleResult();

            System.out.println(processDefinition);
            //部署id
            String deploymentId = processDefinition.getDeploymentId();

            //bpmn资源文件名称
            String resourceName_bpmn = processDefinition.getResourceName();
            //bpmn资源文件输入流
            InputStream inputStream_bpmn = repositoryService.getResourceAsStream(deploymentId, resourceName_bpmn);
            //png文件名称
            String resourceName_png = processDefinition.getDiagramResourceName();
            //png资源文件输入流
            InputStream inputStream_png = repositoryService.getResourceAsStream(deploymentId, resourceName_png);

            //------创建输出流，绑定到response对象-------------------------------------------------------
            OutputStream out = resp.getOutputStream();
            //创建ZIP输出对象，绑定到输出流
            ZipOutputStream zipo = new ZipOutputStream(out);

            //流复制
            byte[] b = new byte[1024];
            int len = -1;

            //定义zip压缩包中的文件对象（zip实体）
            ZipEntry ze = new ZipEntry(resourceName_bpmn);
            //把创建的实体对象放到压缩包中
            zipo.putNextEntry(ze);
            //文件内容拷贝
            while((len = inputStream_bpmn.read(b,0,1024)) != -1){
                zipo.write(b,0,len);
            }
            zipo.closeEntry();
            //---------------
            ZipEntry ze1 = new ZipEntry(resourceName_png);
            zipo.putNextEntry(ze1);
            while((len = inputStream_png.read(b,0,1024)) != -1){
                zipo.write(b,0,len);
            }
            //关闭流
            inputStream_bpmn.close();
            inputStream_png.close();
            zipo.flush();
            zipo.close();
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查看流程图
    @RequestMapping("/viewProcessImage")
    public String viewProcessImage(String did, String imageName, HttpServletResponse resp){
        try {
            imageName = new String(imageName.getBytes("iso8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            OutputStream out = resp.getOutputStream();
            resp.reset();
            InputStream in = repositoryService.getResourceAsStream(did,imageName);
            // 把图片的输入流程写入resp的输出流中
            byte[] b = new byte[1024];
            for (int len = -1   ; (len= in.read(b))!=-1; ) {
                out.write(b, 0, len);
            }
            // 关闭流
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
