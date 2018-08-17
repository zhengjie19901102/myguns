package com.stylefeng.guns.config;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * I18n国际化配置
 */
public class I18nConfig implements Function {
    @Override
    public Object call(Object[] objects, Context context) {
        HttpServletRequest request = (HttpServletRequest )context.getGlobal("request");
        RequestContext requestContext = new RequestContext(request);
        String message = "";
        try {
            String str = (String)objects[0];
            message = requestContext.getMessage((String)objects[0]);
            if("".equals(message) && objects.length > 1){
                message = (String)objects[(int)(1+Math.random()*(objects.length-1))];
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(objects.length > 1)
                message = (String)objects[(int)(1+Math.random()*(objects.length-1))];
        }
        return message;
    }
}
