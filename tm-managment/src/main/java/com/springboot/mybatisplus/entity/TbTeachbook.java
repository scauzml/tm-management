package com.springboot.mybatisplus.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 教材
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_teachbook")
@EqualsAndHashCode(callSuper = true)
public class TbTeachbook extends BaseEntity<TbTeachbook> {

    private static final long serialVersionUID = 1L;


    /**
     * 书名
     */
    @TableField("book_name")
    private String bookName;
    /**
     * 作者
     */
    @TableField("actor")
    private String actor;
    /**
     * 出版社
     */
    @TableField("phishing")
    private String phishing;
    /**
     * 出版时间
     */
    @TableField("pushingtime")
    private String pushingtime;
    /**
     * 图片路径
     */
    @TableField("image_url")
    private String imageUrl;
    /**
     * 定价
     */
    @TableField("price")
    private String price;



}
