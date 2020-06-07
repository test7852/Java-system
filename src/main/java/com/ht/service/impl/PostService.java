package com.ht.service.impl;

import com.ht.bean.Post;
public interface PostService{


    int deleteByPrimaryKey(Integer posId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer posId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

}
