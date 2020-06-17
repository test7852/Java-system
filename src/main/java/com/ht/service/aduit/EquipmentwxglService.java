package com.ht.service.aduit;

import com.ht.bean.aduit.Equipmentwxgl;
    /**
 * @author 王金宝
 * @date 2020/6/16 20:43
 * 
 */
public interface EquipmentwxglService{


    int deleteByPrimaryKey(Integer wxid);

    int insert(Equipmentwxgl record);

    int insertSelective(Equipmentwxgl record);

    Equipmentwxgl selectByPrimaryKey(Integer wxid);

    int updateByPrimaryKeySelective(Equipmentwxgl record);

    int updateByPrimaryKey(Equipmentwxgl record);

}
