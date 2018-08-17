package com.stylefeng.guns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Component
public class I18nInterceptor implements HandlerInterceptor {

    @Autowired
    private LocaleResolver localeResolver;
    //国际化cookie
    private static String  CONTET= "LOCAL_LUANGEUAGE";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object o) throws Exception {
        /**
         * 当语言为en时，默认国家设置为US(美国)
         */
        Cookie[] cookies = request.getCookies();
        String value = null;
        for (Cookie cookie:cookies) {
            String name = cookie.getName();
            if(CONTET.equals(name)){
                value = cookie.getValue();
            }
        }
        if(value == null){
            localeResolver.setLocale(request,response,new Locale("zh","CN"));
            response.addCookie(new Cookie(CONTET,"zh_CN"));
        }else if("en_US".equals(value)){
            localeResolver.setLocale(request,response,new Locale("en","US"));
            response.addCookie(new Cookie(CONTET,"en_US"));
        }else if ("zh_CN".equals(value)){
            response.addCookie(new Cookie(CONTET,"zh_CN"));
            localeResolver.setLocale(request,response,new Locale("zh","CN"));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object o, Exception e) throws Exception {
    }
}
