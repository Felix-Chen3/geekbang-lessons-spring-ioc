package spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import spring.ioc.overview.domain.User;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @author felix
 * @date 2020/12/19
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder 构建
        // generic 是较为常见的配置
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id", 34);
        beanDefinitionBuilder.addPropertyValue("name", "three");
        // 获取 BeanDefinition 实例
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 后续也可以继续进行补充 BeanDefinition 并非最终状态


        // 2.通过 AbstractBean
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 34)
                .add("name", "four");
        // 通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);


    }
}
