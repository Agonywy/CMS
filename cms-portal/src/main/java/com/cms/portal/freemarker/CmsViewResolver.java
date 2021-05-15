package com.cms.portal.freemarker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 自定义FreeMarkerView,用来配置项目全局的绝对路径
 * 通过重写exposeHelpers()方法,在spring里配置自己的freemarker的视图解析器
 * 在模板中就可以通过${base}获取
 *
 * @author 29237
 */
@Slf4j
public class CmsViewResolver extends FreeMarkerView {
    private static final String ADMIN_PATH = "/admin/cms/";
    /**
     * Expose helpers unique to each rendering operation.
     * @param model
     * @param request
     * @throws Exception
     */
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        //这个路径只有后台需要
        if(requestURI.contains(ADMIN_PATH)){
            model.put("adminPath",contextPath+servletPath);
        }

        //虚拟路径: 前台和后台都需要这个路径
        model.put("basePath", contextPath);
    }
}
