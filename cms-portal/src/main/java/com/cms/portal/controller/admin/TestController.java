package com.cms.portal.controller.admin;

import com.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 29237
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;

   @GetMapping("test")
    public void test(){
        int count = testService.count();
        System.out.println(count);
    }
}


