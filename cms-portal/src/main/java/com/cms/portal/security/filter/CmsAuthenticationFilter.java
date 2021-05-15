package com.cms.portal.security.filter;

import netscape.javascript.JSObject;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * FormAuthenticationFilter：专门对表单的拦截器
 * 自定义登录认证拦截器: 继承FormAuthenticationFilter并重写核心逻辑
 *
 * @author 29237
 */
public class CmsAuthenticationFilter extends FormAuthenticationFilter {

    private static final String ADMIN_LOGIN = "/admin/cms/login.do";


    /**
     * 前台登录页面的登录请求login.jspx与后台登录页面的登录请求login.do都会被拦截
     * 这个方法是用来判断当前请求是否为登录请求,但是他现在只能识别前台登录地址的请求
     * 后台访问登录地址的时候会被跳转到前台的登录页面中去
     * 所以这里通过重写isLoginRequest()方法来让CmsAuthenticationFilter识别后台登录请求
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(),request) ||
                this.pathsMatch(ADMIN_LOGIN,request);
    }

    /**
     * 如果用户是一个http的post请求,那么就执行executeLogin(request,response)方法做登录操作
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

        response.setCharacterEncoding("utf-8");
        //通过MIME类型来处理json字符串
        //setContentType(MIME)方法设置发送到客户端浏览器的响应的数据格式
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write("");
        return true;
    }


}


