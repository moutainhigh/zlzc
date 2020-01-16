package com.zlzc.common.security.authorize.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.zlzc.common.security.authorize.AuthorizeConfigManager;
import com.zlzc.common.security.authorize.AuthorizeConfigProvider;

/**
 * 默认的授权配置管理器
 * 
 * @author Lsr
 *
 */
@Component
public class ZlzcAuthorizeConfigManager implements AuthorizeConfigManager {

	@Autowired
	private List<AuthorizeConfigProvider> authorizeConfigProviders;
	
//	@Autowired(required = false)
//	private MethodSecurityMetadataSource methodSecurityMetadataSource;
	
	@Override
	public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		
//		Collection<ConfigAttribute> allMethodConfigAttributes = methodSecurityMetadataSource.getAllConfigAttributes();
		
		boolean existAnyRequestConfig = false;
		String existAnyRequestConfigName = null;
		
		for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
			boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(config);
			if (existAnyRequestConfig && currentIsAnyRequestConfig) {
				throw new RuntimeException("重复的anyRequest配置:" + existAnyRequestConfigName + ","
						+ authorizeConfigProvider.getClass().getSimpleName());
			} else if (currentIsAnyRequestConfig) {
				existAnyRequestConfig = true;
				existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
			}
		}
		
		if(!existAnyRequestConfig){
			config.anyRequest().authenticated();
		}
	}

}
