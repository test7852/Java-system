package com.ht.service.emp;

import com.ht.bean.emp.Post;
import com.ht.util.Pager;

import java.util.List;

public interface PostService{

    /**
     * @return
     * 查询总数
     */
    int getTotalRow();

    /**
     * @param pager
     * @return
     * 分页查询
     */
    List<Post> allPagePost(Pager pager);
    /**
     * @param postName
     * @return
     * 根据职位名称查找职位
     */
    Post selectByName(String postName);

    /**
     * @return
     * 查找所有不在校长和副校长的职位
     */
    List<Post> selolist();

    /**
     * @return
     * 查找校长和副校长的职位
     */
    List<Post> elselist();

    /**
     * @return
     * 查找所有职位
     */
    List<Post> list();


    int deleteByPrimaryKey(Integer posId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer posId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

}
