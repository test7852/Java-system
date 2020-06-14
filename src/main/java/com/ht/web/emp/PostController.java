package com.ht.web.emp;

import com.fasterxml.jackson.core.JsonToken;
import com.ht.bean.emp.Dep;
import com.ht.bean.emp.Post;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.PostService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/14 10:29
 */
@Controller
@RequestMapping("post")
public class PostController {
    @Resource
    private JsonData jsonData;
    @Resource
    private PostService postService;


    /**
     * @param limit
     * @param page
     * @return
     * 获取职位信息
     */
    @RequestMapping("postdata")
    @ResponseBody
    public JsonData  postdata(int limit,int page){

        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(postService.getTotalRow());
        jsonData.setData(postService.allPagePost(pager));
        return jsonData;
    }

    /**
     * @param post
     * @return
     * 修改职位信息
     */
    @RequestMapping("update")
    @ResponseBody
    public Boolean  update(Post post){
        Post post1 = postService.selectByName(post.getPos_Name());
        if(post1 == null){
            postService.updateByPrimaryKeySelective(post);
            return true;
        }
        return false;
    }

    /**
     * @param id
     * @return
     * 删除职位
     */
    @RequestMapping("del")
    @ResponseBody
    public Boolean del(Integer id){
        int b = postService.deleteByPrimaryKey(id);
        if(b>0){
            return true;
        }
        return false;
    }

    /**
     * @param post
     * @return
     * 添加职位
     */
    @RequestMapping("add")
    @ResponseBody
    public Boolean add(Post post){
        Post post1 = postService.selectByName(post.getPos_Name());
        System.out.println(post.toString());
        if(post1 == null){
            System.out.println("======");
            postService.insert(post);
            return true;
        }
        return false;
    }


}
