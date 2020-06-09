package com.ht.util;

import com.ht.bean.Datadoc;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utils {

    public static Datadoc fileUpload(MultipartFile file) throws IOException {
        //生成一个唯一的文件名
        String picName = UUID.randomUUID().toString();;

        //截取文件后缀名
        String oriName = file.getOriginalFilename();
        String extName = oriName.substring(oriName.lastIndexOf("."));
        if ("".equals(oriName) || oriName == ""){
            return null;
        }

        //设置该文件存储位置，并保存该文件
        String dirName = Contants.PRO_FILE_SAVE_PATH;
        //创建文件夹
        File dirFile = new File(dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //新文件名
        String newFileName = picName + extName;
        File targetFile = new File(dirName , newFileName);
        file.transferTo(targetFile);

        return new Datadoc(0,oriName,newFileName,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),"aa",1);
        //返回新文件名
    }
}
