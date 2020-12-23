package spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import spring.ioc.overview.domain.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author felix
 * @date 2020/12/20
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    /**
     * 1.基于 @PostConstruct 注解
     */
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct");
    }

    /**
     * 基于 @Bean 去指定 initial
     */
    public void initUserFactory() {
        System.out.println("@Bean(initMethod = initUserFactory)");
    }

    /**
     * 基于 Spring 官方{@link org.springframework.beans.factory.InitializingBean} 接口实现
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet()");
    }



    /**
     * 1.基于 @PreDestroy 注解
     */
    @PreDestroy
    public void destroyBean() {
        System.out.println("@PreDestroy");
    }


    @Override
    public void destroy() throws Exception {

    }
}
