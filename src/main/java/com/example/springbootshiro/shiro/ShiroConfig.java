package com.example.springbootshiro.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**\
 * shiro配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager ){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * SHiro内置过滤器
         */
        Map<String,String> filterMap=new LinkedHashMap<>();
        //不需要认证
        filterMap.put("/user/controller/login","anon");

        //授权
        filterMap.put("/user/controller/add","perms[user:add]");

        filterMap.put("/user/controller/upd","perms[user:upd]");

        filterMap.put("/*","authc");
        //不需要验证
        //需要验证

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //设置登录页
        shiroFilterFactoryBean.setLoginUrl("/user/controller/tologin");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/controller/noauth");
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        实例化
        DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */

    @Bean("userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置shiroDialect 用于扩展的使用
     *
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
