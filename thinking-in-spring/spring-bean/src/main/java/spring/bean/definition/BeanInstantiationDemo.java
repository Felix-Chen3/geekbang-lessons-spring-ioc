package spring.bean.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.domain.User;

/**
 * @author felix
 * @date 2020/12/20
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:bean-instantiation-context.xml");
        User user = classPathXmlApplicationContext.getBean("user-by-static-method", User.class);
        User user1 = classPathXmlApplicationContext.getBean("user-by-instance-method", User.class);
        User user2 = classPathXmlApplicationContext.getBean("user-by-factory-bean", User.class);

        System.out.println(user+"\n"+user1+"\n"+user2);

    }
}
