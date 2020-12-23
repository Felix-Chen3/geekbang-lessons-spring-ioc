package spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.repository.UserRepository;

/**
 * @author felix
 * @date 2020/12/7
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文 (为什么可以直接使用 BeanFactory 进行类型替换？)
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println("(userRepository.getBeanFactory() == beanFactory)= " + (userRepository.getBeanFactory() == beanFactory));

        // 依赖注入
        System.out.println(userRepository.getBeanFactory());

        // 依赖查找
        // 结果发现 依赖注入可以完成，而依赖查找失败了
        // 因为他们的来源不是同源
//        System.out.println(userRepository.getBeanFactory().getBean(BeanFactory.class));


        ApplicationContext object = userRepository.getObjectFactory().getObject();
        // 为什么自动注入了一个 applicationContext 就是 beanFactory？
        System.out.println(object==beanFactory);


    }


}
