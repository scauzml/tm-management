package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.entity.TbClass;

import java.util.Map;

/**
 * <p>
 * 班级 服务类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
public interface ClassService extends IService<TbClass> {

    /**
     * @author zml
     *
     * @param null
     * @return
     * 查询班级列表
     *
     */
    PageObject<TbClass> getClassPage(Map<String, Object> params);

    /**
     * @param null
     * @return 增加
     * @author zml
     */
    void save(TbClass tbClass);

    /**
     * @param null
     * @return 更新
     * @author zml
     */
    void update(TbClass tbClass);

    /**
     * @param null
     * @return
     * @author zml
     * 逻辑删除
     */
    void delete(TbClass tbClass);
}
