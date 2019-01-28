package com.springboot.mybatisplus.service.impl;

;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbNoticeMapper;
import com.springboot.mybatisplus.entity.TbNotice;
import com.springboot.mybatisplus.service.ITbNoticeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class TbNoticeServiceImpl extends ServiceImpl<TbNoticeMapper, TbNotice> implements ITbNoticeService {

}
