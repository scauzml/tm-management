package com.springboot.mybatisplus.util;

public class SqlUtil {

    private static final String ESCAPE_CHAR = "\\";

    /**
     * 替换sql中的模糊特殊字符 _ % \
     * 该方法只在mybatis + mysql下测试通过，如更换dao层框架或者数据库，则需重新测试
     * 请注意，下面这种替换方式，只支持preparedstatement，即对应#{},而无法支持${}
     */
    public static String repalceWildcard(String str) {
        String result = null;
        if (str != null) {
            result = str.replace(ESCAPE_CHAR, ESCAPE_CHAR + ESCAPE_CHAR);
            result = result.replace("%", ESCAPE_CHAR + "%");
            result = result.replace("_", ESCAPE_CHAR + "_");
        }
        return result;
    }

}
