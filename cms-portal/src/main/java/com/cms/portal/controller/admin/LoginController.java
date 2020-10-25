package com.cms.portal.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 29237
 */
@Controller
public class LoginController {
    @GetMapping("login.do")
    public String toLogin(){
        return "/admin/login";
    }

}
