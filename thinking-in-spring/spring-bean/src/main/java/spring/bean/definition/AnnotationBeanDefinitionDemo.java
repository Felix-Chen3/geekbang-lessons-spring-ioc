package spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import spring.bean.configTest.Config;
import spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * 通过 @Import 的方式定义
 */
@Import(Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建 BeanDefinition 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class (配置类)
        annotationConfigApplicationContext.register(AnnotationBeanDefinitionDemo.class);
        // @Component 需要配合扫描注解
        annotationConfigApplicationContext.scan("spring/bean/configTest");
        // 启动应用上下文
        annotationConfigApplicationContext.refresh();
        // 通过 Bean 类型获取
        Map<String, Config> beansOfType = annotationConfigApplicationContext.getBeansOfType(Config.class);
        beansOfType.forEach((key,value)->{
            System.out.println(key+":"+value);
        });

        User user = annotationConfigApplicationContext.getBean("user", User.class);
        System.out.println(user);
        // 显示的关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();
    }
}

