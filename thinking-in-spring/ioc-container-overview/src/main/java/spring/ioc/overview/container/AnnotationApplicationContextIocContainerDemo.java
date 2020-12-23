package spring.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * {@link ApplicationContext}
 * @author felix
 * @date 2020/12/10
 */
public class AnnotationApplicationContextIocContainerDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 bean ，以当前类为例
        applicationContext.register(AnnotationApplicationContextIocContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 查找对象
        lookupCollectionByType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * 通过 Java 注解的方式，定义一个 Bean
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(333L);
        user.setName("dudu");
        return user;
    }


    private static void lookupCollectionByType(BeanFactory beanFactory) {
        // 返回一个 ID：bean 的map
        ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
        Map<String, User> users = factory.getBeansOfType(User.class);
        System.out.println("查找到的所有 User 集合对象" + users);
    }
}
