package com.springboot.mybatisplus.validator;

/**
 * Created by nickdeng on 2018/7/18.
 */
public class ValidatorConstant {
    /**
     * 角色名称校验规则：1-32位，中文，数字，字母
     */
    public final static String ROLE_PATTERN = "^[\\u4E00-\\u9FA5A-Za-z0-9]{1,32}$";

    /**
     * 人员帐号：长度1-16个字符，由字母、数字、点(.)、减号(-)、空格或下划线(_)组成；
     */
    public final static String ACCOUNT_PATTERN = "[\\w\\d\\.\\-\\_\\s]{1,16}";


    /**
     * 检验数字
     */
    public final static String NUMBER_PATTERN = "^[0-9]*$";

    /**
     * 名称只能为中文或英文!
     */
    public final static String CHINAESE_ENGLISH_PATTERN = "^[a-zA-Z]{1,32}$|^[\\u4e00-\\u9fa5]{1,32}$";
}
