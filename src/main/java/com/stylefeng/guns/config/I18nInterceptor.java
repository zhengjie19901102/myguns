package com.stylefeng.guns.config;

import com.stylefeng.guns.core.util.CookieUtil;
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
        String value = CookieUtil.getCookieValue(request,CONTET);
        if(value == null){
            localeResolver.setLocale(request,response,new Locale("zh"));
            response.addCookie(new Cookie(CONTET,"zh"));
        }else if(value.contains("en")){
            localeResolver.setLocale(request,response,new Locale("en"));
            response.addCookie(new Cookie(CONTET,"en"));
        }else if (value.contains("zh")){
            response.addCookie(new Cookie(CONTET,"zh"));
            localeResolver.setLocale(request,response,new Locale("zh"));
        }else if(value.contains("fr")){
            response.addCookie(new Cookie(CONTET,"fr"));
            localeResolver.setLocale(request,response,new Locale("fr"));
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
