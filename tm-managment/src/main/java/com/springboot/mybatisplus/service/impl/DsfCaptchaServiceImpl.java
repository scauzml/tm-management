/**
 * Copyright 2018 道一信息 http://do1.com.cn
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import com.springboot.mybatisplus.dao.DsfCaptchaDao;
import com.springboot.mybatisplus.entity.DsfCaptchaEntity;
import com.springboot.mybatisplus.exception.RestException;
import com.springboot.mybatisplus.service.DsfCaptchaService;
import com.springboot.mybatisplus.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 * @since 2.0.0 2018-02-10
 */
@Service("dsfCaptchaService")
public class DsfCaptchaServiceImpl extends ServiceImpl<DsfCaptchaDao, DsfCaptchaEntity> implements DsfCaptchaService {
    @Autowired
    private Producer producer;
    @Value("${do1.authorize.test-captcha:11111}")   //测试验证码
    private String testCaptcha;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new RestException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        DsfCaptchaEntity captchaEntity = new DsfCaptchaEntity();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        this.insert(captchaEntity);

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        DsfCaptchaEntity captchaEntity = this.selectOne(new EntityWrapper<DsfCaptchaEntity>().eq("uuid", uuid));
        if(captchaEntity == null && !testCaptcha.equals(code)){
            return false;
        }
        //删除验证码
        this.deleteById(uuid);

        if(testCaptcha.equals(code)){
            return true;
        }
        if(captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }

        return false;
    }
}
