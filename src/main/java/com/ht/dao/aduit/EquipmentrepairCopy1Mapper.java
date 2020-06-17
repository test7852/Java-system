package com.ht.dao.aduit;

import com.ht.bean.aduit.EquipmentrepairCopy1;

/**
 * @author 王金宝
 * @date 2020/6/16 20:42
 * 
 */
public interface EquipmentrepairCopy1Mapper {
    int deleteByPrimaryKey(Integer equipmentid);

    int insert(EquipmentrepairCopy1 record);

    int insertSelective(EquipmentrepairCopy1 record);

    EquipmentrepairCopy1 selectByPrimaryKey(Integer equipmentid);

    int updateByPrimaryKeySelective(EquipmentrepairCopy1 record);

    int updateByPrimaryKey(EquipmentrepairCopy1 record);
}