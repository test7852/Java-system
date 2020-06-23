package com.ht.util;

/**
 * Created by Administrator on 2020/4/27.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 静态常量类
 */
public class Contants {
    /**
     * 文件上传路径
     */
    public static final String PRO_FILE_SAVE_PATH="D:\\fFile\\doc\\";


    /**
     * 文件上传路径2
     */
    public static final String PRO_FILE_SAVE_ADUIT="D:\\fFile\\aduit\\";




    /**
     * 启用
     */
    public static final int STATUS_SU=1;
    /**
     * 禁用
     */
    public static final int STATUS_SW=2;

    /**
     * 默认密码
     */
    public static final String PASSWORD_TA="123456";

    /**
     * 班主任
     */
    public static final Integer POST_CLASS=4;
    /**
     * 教师
     */
    public static final Integer POST_TEACHER=5;
    /**
     * 员工请假-已完成
     */
    public static final Integer HOLIDAY_OK=2;
    /**
     * 员工请假-审批中
     */
    public static final Integer HOLIDAY_LOADING=1;
    /**
     * 员工请假-未批准
     */
    public static final Integer HOLIDAY_NOT=3;
}
