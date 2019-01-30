package com.springboot.mybatisplus.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author zhangmingliang
 * @date 2019-01-30 14:05
 */
@Data
@ApiModel("用户个人中心信息")
public class UserInformationVo {

    /**
     * 图片名字
     */
    private String image;
    /**
     * 学院
     */

    private String academy;

    /**
     * 班級
     */
    private String classyear;
    /**
     * 学生id
     */

    private String userStudentid;

    /**
     * 真实姓名
     */

    private String name;
    /**
     * 手机号码
     */

    private String phone;
    /**
     * 邮箱
     */

    private String email;


}
