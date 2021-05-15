package com.cms.portal.security.filter;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.web.filter.authc.UserFilter;

/**
 * 自定义user用户已登录拦截器(用户跳转拦截器)
 * @author 29237
 */
@Getter
@Setter
public class CmsUserFilter extends UserFilter {
    private String adminLoginUrl;
    private String adminPrefix;
}
