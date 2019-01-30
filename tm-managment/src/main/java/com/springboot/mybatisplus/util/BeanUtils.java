package com.springboot.mybatisplus.util;


import lombok.extern.slf4j.Slf4j;
import cn.hutool.core.bean.BeanUtil;
import java.util.ArrayList;
import java.util.List;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.cn;

/**
 * bean对象操作类
 * Created by zws on 2018/8/20.
 */
@Slf4j
public class BeanUtils extends BeanUtil {

    public static <T> List<T> copyProperties(List<?> list, Class<T> c){
        List<T> ts = new ArrayList<>(list.size());
        for (Object o : list) {
            try {
                T t = c.newInstance();
                copyProperties(o, t);
                ts.add(t);
            } catch (InstantiationException | IllegalAccessException e) {
                log.error("copy属性异常:" , e);
            }
        }
        return ts;
    }

    public static <T> PageObject<T> pageConvert(PageObject<?> page, Class<T> c){
        return new PageObject<T>(copyProperties(page.getList(), c), (int)page.getTotalCount(), page.getPageSize(), page.getCurrPage());
    }
}
