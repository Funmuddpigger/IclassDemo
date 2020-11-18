package com.classadm.demo.config;

import com.classadm.demo.shiro.MyCusRealms;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //filter安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源,配置公共资源
        Map<String,String> filtermap = new HashMap<>();
//        shiroFilterFactoryBean.setLoginUrl("/");
//        filtermap.put("/","anon");
//        filtermap.put("/static/**","anon");
//        filtermap.put("/login","anon");
//        filtermap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);

        return shiroFilterFactoryBean;
    }
    //安全管理器
    @Bean
    public DefaultWebSecurityManager getdefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    //Realm
    @Bean
    public Realm realm(){
        MyCusRealms myCusRealms = new MyCusRealms();
        //修改密码行政校验匹配器
        return myCusRealms;
    }
}
