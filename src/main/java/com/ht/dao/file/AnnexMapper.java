package com.ht.dao.file;

import com.ht.bean.file.Annex;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrq
 * @date 2020/6/19 8:36
 * 
 */
public interface AnnexMapper {

    int selCount();//查询总数

    List<Annex> sellist(@Param("page")Pager pager,@Param("seName")String seName,@Param("seId")Integer seId);//按用户的资料分页

    int deleteByPrimaryKey(Integer annexid);

    int insert(Annex record);

    int insertSelective(Annex record);

    Annex selectByPrimaryKey(Integer annexid);

    int updateByPrimaryKeySelective(Annex record);

    int updateByPrimaryKey(Annex record);
}