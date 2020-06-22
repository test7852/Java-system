package com.ht.service.education.impl;

import com.ht.util.Pager;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.dao.education.ClasstypeMapper;
import com.ht.bean.education.Classtype;
import com.ht.service.education.ClasstypeService;

import java.util.List;

/**
 * @author 王金宝
 * @date 2020/6/19 19:10
 * 
 */
@Service
public class ClasstypeServiceImpl implements ClasstypeService{

    @Resource
    private ClasstypeMapper classtypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer classtypeid) {
        return classtypeMapper.deleteByPrimaryKey(classtypeid);
    }

    @Override
    public int insert(Classtype record) {
        return classtypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Classtype record) {
        return classtypeMapper.insertSelective(record);
    }

    @Override
    public Classtype selectByPrimaryKey(Integer classtypeid) {
        return classtypeMapper.selectByPrimaryKey(classtypeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Classtype record) {
        return classtypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classtype record) {
        return classtypeMapper.updateByPrimaryKey(record);
    }

    //查找classtype数据

    /**
     * @半口香甜吴一玄 班级类别方法
     * @param pager
     * @return
     */
    @Override
    public List<Classtype> classtpedata(Pager pager) {
        return classtypeMapper.classtypedata(pager);
    }

    @Override
    public List<Classtype> alldata() {
        return classtypeMapper.alldata();
    }

    @Override
    public int getclasstypeRow() {
        return classtypeMapper.getclasstypeRow();
    }


}
