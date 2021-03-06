package com.szx.server.config.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 判断用户的角色
 * 判断当前用户是否具备指定的角色
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 用户的角色在 authentication里，资源需要的角色在 collection 中
        for (ConfigAttribute configAttribute : configAttributes) {
            // 当前url所需要的角色
            String needRole = configAttribute.getAttribute();
            // 如果角色登录即可访问
            if("ROLE_LOGIN".equals(needRole)) {
                if(authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("还没有登录!!!");
                } else {
                    return;
                }
            } 
            // 判断用户角色是否为url所需要
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if(authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!!!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
