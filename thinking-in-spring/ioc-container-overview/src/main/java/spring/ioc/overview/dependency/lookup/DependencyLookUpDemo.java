package spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.annotation.Super;
import spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * @author felix
 * @date 2020/12/6
 */
public class DependencyLookUpDemo {
    public static void main(String[] args) {
        // 1. 实时查找
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文 (为什么可以直接使用 BeanFactory 进行类型替换？)
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        lookupInLazy(beanFactory);
        lookupInRealTime(beanFactory);
        // 按照类型查找
        lookupByType(beanFactory);
        // 按照类型查找集合对象
        lookupCollectionByType(beanFactory);
        // 通过注解查找对象
        lookupByAnnotationType(beanFactory);

    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
        Map<String, Object> beansWithAnnotation = factory.getBeansWithAnnotation(Super.class);
        System.out.println("查找标注 @Super 所有的对象集合" + beansWithAnnotation);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        // 返回一个 ID：bean 的map
        ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
        Map<String, User> users = factory.getBeansOfType(User.class);
        System.out.println("查找到的所有 User 集合对象" + users);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User object = objectFactory.getObject();
        System.out.println("延迟查找" + object);
    }
}
