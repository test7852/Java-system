package com.ht.service.aduit.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ht.bean.aduit.EquipmentrepairCopy1;
import com.ht.dao.aduit.EquipmentrepairCopy1Mapper;
import com.ht.service.aduit.EquipmentrepairCopy1Service;
/**
 * @author 王金宝
 * @date 2020/6/16 20:42
 * 
 */
@Service
public class EquipmentrepairCopy1ServiceImpl implements EquipmentrepairCopy1Service{

    @Resource
    private EquipmentrepairCopy1Mapper equipmentrepairCopy1Mapper;

    @Override
    public int deleteByPrimaryKey(Integer equipmentid) {
        return equipmentrepairCopy1Mapper.deleteByPrimaryKey(equipmentid);
    }

    @Override
    public int insert(EquipmentrepairCopy1 record) {
        return equipmentrepairCopy1Mapper.insert(record);
    }

    @Override
    public int insertSelective(EquipmentrepairCopy1 record) {
        return equipmentrepairCopy1Mapper.insertSelective(record);
    }

    @Override
    public EquipmentrepairCopy1 selectByPrimaryKey(Integer equipmentid) {
        return equipmentrepairCopy1Mapper.selectByPrimaryKey(equipmentid);
    }

    @Override
    public int updateByPrimaryKeySelective(EquipmentrepairCopy1 record) {
        return equipmentrepairCopy1Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(EquipmentrepairCopy1 record) {
        return equipmentrepairCopy1Mapper.updateByPrimaryKey(record);
    }

}
