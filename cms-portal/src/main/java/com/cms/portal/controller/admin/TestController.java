package com.cms.portal.controller.admin;

import com.cms.service.api.TestService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 29237
 */
@Controller
public class TestController {
    @Resource
    private TestService testService;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private Producer captchaProducer;

    @GetMapping("test")
    public String test(){
        return "/admin/test/index";
    }

    /**测试集成Jedis*/
    @RequestMapping("/testRedis")
    public void testRedis(){
       redisTemplate.opsForValue().set("love","琦琦");
       String love = (String) redisTemplate.opsForValue().get("love");
       System.out.println(love);
   }

    /**测试请求验证码*/
    @GetMapping("captch.do")
    public void daCaptcha(HttpServletResponse httpServletResponse){
        //先生成文本内容，然后根据文本串去生成验证码图片
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);
        /**try-with-resource语法糖: 资源会自动关闭,不用我们手动关闭了*/
        try(ServletOutputStream outputStream = httpServletResponse.getOutputStream();){
            ImageIO.write(image,"jpg",outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


