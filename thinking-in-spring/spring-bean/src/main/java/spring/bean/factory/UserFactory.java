package spring.bean.factory;

import spring.ioc.overview.domain.User;

/**
 * @author felix
 * @date 2020/12/20
 */
public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}
