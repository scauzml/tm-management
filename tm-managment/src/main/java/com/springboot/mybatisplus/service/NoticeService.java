package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.entity.TbNotice;

import java.util.Map;

/**
 * <p>
 * 公告 服务类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
public interface NoticeService extends IService<TbNotice> {

    /**
     * @author zml
     *
     * @param null
     * @return
     * 查询公告表
     *
     */
    PageObject<TbNotice> getNoticePage(Map<String, Object> params);

    /**
     * @param null
     * @return 增加
     * @author zml
     */
    void save(TbNotice tbNotice);

    /**
     * @param null
     * @return 更新
     * @author zml
     */
    void update(TbNotice tbNotice);

    /**
     * @param null
     * @return
     * @author zml
     * 逻辑删除
     */
    void delete(TbNotice tbNotice);
}
