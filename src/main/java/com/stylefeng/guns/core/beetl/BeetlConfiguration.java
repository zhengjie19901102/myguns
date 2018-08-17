package com.stylefeng.guns.core.beetl;

import com.stylefeng.guns.config.I18nConfig;
import com.stylefeng.guns.core.util.ToolUtil;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

	@Override
	public void initOther() {

		groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
		groupTemplate.registerFunctionPackage("tool", new ToolUtil());
		//注册i18n函数
		groupTemplate.registerFunction("i18n",new I18nConfig());
	}

}
