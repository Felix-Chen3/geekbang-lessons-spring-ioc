package spring.bean.configTest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import spring.ioc.overview.domain.User;

/**
 * 通过 @Component 的方式定义
 */
@Component
public class Config {
    /**
     * 通过 @Bean 的方式定义
     */
    @Bean(name = {"user", "three"})
    public User user() {
        User user = new User();
        user.setName("dudu");
        user.setId(22L);
        return user;
    }
}
