package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.util.PageObject;

import java.util.Map;

/**
 * <p>
 * 学院 服务类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
public interface AcademyService extends IService<TbAcademy> {
   /**
    * @author zml
    *
    * @param null
    * @return
    * 查询学院列表
    *
    */
    PageObject<TbAcademy> getTbAcademyPage(Map<String, Object> params);

    /**
     * @param null
     * @return 增加
     * @author zml
     */
    void save(TbAcademy tbAcademy);

    /**
     * @param null
     * @return 更新
     * @author zml
     */
    void update(TbAcademy tbAcademy);

    /**
     * @param null
     * @return
     * @author zml
     * 逻辑删除
     */
    void delete(TbAcademy tbAcademy);
}
