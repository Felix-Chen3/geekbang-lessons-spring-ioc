package spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.bean.factory.UserFactory;
import spring.bean.factory.DefaultUserFactory;

/**
 * @author felix
 * @date 2020/12/21
 */
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {

        // 创建 BeanDefinition 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class (配置类)
        annotationConfigApplicationContext.register(BeanInitializationDemo.class);
        // 启动应用上下文
        annotationConfigApplicationContext.refresh();
        // 依赖查找
        UserFactory factory = annotationConfigApplicationContext.getBean(UserFactory.class);
        // 关闭应用上下文
        annotationConfigApplicationContext.close();
    }

    @Bean
    public DefaultUserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
