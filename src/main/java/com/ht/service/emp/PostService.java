package com.ht.service.emp;

import com.ht.bean.emp.Post;
public interface PostService{


    int deleteByPrimaryKey(Integer posId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer posId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

}
