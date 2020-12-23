package spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.domain.User;

/**
 * @author felix
 * @date 2020/12/20
 */
public class BeanAliasDemo {
    public static void main(String[] args) {

        // 1. 实时查找
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文 (为什么可以直接使用 BeanFactory 进行类型替换？)
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:bean-definitions-context.xml");
        // 通过别名访问 user
        User user = beanFactory.getBean("user", User.class);
        User user1 = beanFactory.getBean("user1", User.class);
        User user2 = beanFactory.getBean("user2", User.class);
        User user3 = beanFactory.getBean("user3", User.class);
        User three = beanFactory.getBean("three-user", User.class);
        System.out.println(three == user && user1 == user2 && user2 == user3 && user3 == three);


    }

}
