package com.ht.service.emp.impl;

import com.ht.service.emp.PostService;
import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.emp.Post;
import com.ht.dao.emp.PostMapper;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    private PostMapper postMapper;

    @Override
    public int getTotalRow() {
        return postMapper.getTotalRow();
    }

    @Override
    public List<Post> allPagePost(Pager pager) {
        return postMapper.allPagePost(pager);
    }

    @Override
    public Post selectByName(String postName) {
        return postMapper.selectByName(postName);
    }

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
