package com.stylefeng.guns.modular.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class TestController {

    private static String  CONTET= "LOCAL_LUANGEUAGE";

    @RequestMapping("/ad")
    public String getAd(Model mode, Locale local){
        return "/ad.html";
    }

    @RequestMapping("/bb")
    public String getBb(HttpServletResponse response, String locale){
        response.addCookie(new Cookie(CONTET,locale));
        return "/bb.html";
    }

}
