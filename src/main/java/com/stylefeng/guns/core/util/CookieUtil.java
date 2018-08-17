package com.stylefeng.guns.core.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    /**
     * 获取指定Cookie值
     */
    public static String getCookieValue(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (cookieName.equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
