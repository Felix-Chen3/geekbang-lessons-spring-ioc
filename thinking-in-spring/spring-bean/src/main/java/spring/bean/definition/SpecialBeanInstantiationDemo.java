package spring.bean.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.factory.UserFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author felix
 * @date 2020/12/21
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:bean-instantiation-context.xml");
        demoServiceLoader();
     }

    public static void demoServiceLoader(){
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }
    }

}
