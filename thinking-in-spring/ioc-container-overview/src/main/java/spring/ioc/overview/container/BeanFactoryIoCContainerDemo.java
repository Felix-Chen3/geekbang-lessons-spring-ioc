package spring.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * {@link BeanFactory}
 * @author felix
 * @date 2020/12/10
 */
public class BeanFactoryIoCContainerDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        // bean 加载的数量
        int beanDefinitions = reader.loadBeanDefinitions(location);
        System.out.println(beanDefinitions);
        // 依赖查找集合对象
        lookupCollectionByType(beanFactory);

    }


    private static void lookupCollectionByType(BeanFactory beanFactory) {
        // 返回一个 ID：bean 的map
        ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
        Map<String, User> users = factory.getBeansOfType(User.class);
        System.out.println("查找到的所有 User 集合对象" + users);
    }
}
