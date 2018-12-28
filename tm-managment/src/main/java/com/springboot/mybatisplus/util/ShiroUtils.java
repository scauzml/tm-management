package com.springboot.mybatisplus.util;


import com.springboot.mybatisplus.entity.DsfUserEntity;
import com.springboot.mybatisplus.exception.RestException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月12日 上午9:49:19
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}


	public static DsfUserEntity getDsfUserEntity() {
		return (DsfUserEntity)SecurityUtils.getSubject().getPrincipal();
	}

	public static Long getDsfUserId(){
		return getDsfUserEntity().getUserId();
	}

	public static String getDsfUserName(){
		return getDsfUserEntity().getUserName();
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static String getKaptcha(String key) {
		Object kaptcha = getSessionAttribute(key);
		if(kaptcha == null){
			throw new RestException("验证码已失效");
		}
		getSession().removeAttribute(key);
		return kaptcha.toString();
	}

}
