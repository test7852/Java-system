package com.ht.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.Post;
import com.ht.dao.PostMapper;
import com.ht.service.impl.PostService;
@Service
public class PostServiceImpl implements PostService{

    @Resource
    private PostMapper postMapper;

    @Override
    public int deleteByPrimaryKey(Integer posId) {
        return postMapper.deleteByPrimaryKey(posId);
    }

    @Override
    public int insert(Post record) {
        return postMapper.insert(record);
    }

    @Override
    public int insertSelective(Post record) {
        return postMapper.insertSelective(record);
    }

    @Override
    public Post selectByPrimaryKey(Integer posId) {
        return postMapper.selectByPrimaryKey(posId);
    }

    @Override
    public int updateByPrimaryKeySelective(Post record) {
        return postMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Post record) {
        return postMapper.updateByPrimaryKey(record);
    }

}
