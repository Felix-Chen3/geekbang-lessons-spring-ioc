package spring.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import spring.ioc.overview.domain.User;

/**
 * @author felix
 * @date 2020/12/20
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
