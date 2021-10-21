package com.xz.parking.config;

import com.xz.parking.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: xz
 * @Date: 2021/10/19
 */
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(manager);

        //添加shiro的内置过滤器
        /*
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            user:必须拥有 记住我 功能才能访问
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login/*","anon");
        filterMap.put("/console/*","authc");
        //filterMap.put("/admin/*","perms[all]");//标识带有all标识的管理员才能进行访问
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录的页面
        bean.setLoginUrl("/login/to_login");
        //未授权页面
        bean.setUnauthorizedUrl("/login/denied");


        return bean;
    }

    //DefaultWebSecurityBean
    //通过@Qualifier获取下面的userRealm对象，因为userRealm已近被spring接管，所以直接使用@Qualifier取值即可
    @Bean(name = "manager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("adminRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm对象
        defaultWebSecurityManager.setRealm(userRealm);

        return defaultWebSecurityManager;
    }

    //realm对象
    @Bean
    public UserRealm adminRealm() {
        return new UserRealm();
    }

}