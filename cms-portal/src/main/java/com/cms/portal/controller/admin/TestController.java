package com.cms.portal.controller.admin;

import com.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author 29237
 */
@Controller
public class TestController {
    @Resource
    private TestService testService;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

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
}


