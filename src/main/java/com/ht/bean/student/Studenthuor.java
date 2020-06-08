package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/8 20:43
 *  
 */
/**
    * 宿舍资料  
    */
@Data
public class Studenthuor {
    /**
    * 宿舍主键id
    */
    private Integer hourid;

    /**
    * 宿舍房号(508)
    */
    private String huorname;

    /**
    * 宿舍地址
    */
    private String addr;

    /**
    * 宿舍人数
    */
    private Integer count;

    /**
    * 楼栋id外键
    */
    private Integer floorid;

    /**
    * 床位数
    */
    private Integer numberbeds;

    /**
    * 序号
    */
    private String huoeiddsc;
}