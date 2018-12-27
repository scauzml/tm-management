package com.springboot.mybatisplus.util.query;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author{张明亮} 2018/12/22 17:49
 */
@Data
public class PageCondition {
    private int pageNum = 0;

    @ApiParam("每页数量")
    private int pageSize = 15;

    @ApiParam("排序字段")
    private String order;

    @ApiParam("排序规则 默认降序，升序=ASC")
    private String orderBy = "DESC";

}
