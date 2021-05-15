package com.cms.portal.controller.admin;

import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @author 29237
 */
@Controller
@Slf4j
public class LoginController {
    @Resource
    private Producer captchaProducer;

    /**
     * 直接跳转到页面
     * @return
     */
    @GetMapping("login.do")
    public String toLogin(){
        return "/admin/login";
    }
    /**测试请求验证码*/
    @GetMapping("captcha.do")
    public void daCaptcha(HttpServletResponse httpServletResponse){
        //先生成文本内容，然后根据文本串去生成验证码图片
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);
        /**try-with-resource语法糖: 资源会自动关闭,不用我们手动关闭了*/
        try(ServletOutputStream outputStream = httpServletResponse.getOutputStream();){
            ImageIO.write(image,"jpg",outputStream);
        }catch (Exception e){
            log.error("slf4j日志:验证码生成失败了");
        }
    }




}
