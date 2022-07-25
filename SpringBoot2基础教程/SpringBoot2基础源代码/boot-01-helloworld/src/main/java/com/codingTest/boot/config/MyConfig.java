package com.codingTest.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.codingTest.boot.bean.Car;
import com.codingTest.boot.bean.Pet;
import com.codingTest.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 告诉SpringBoot这是一个配置类 等同于 配置文件
 * 1.配置类可以使用@bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods: 代理bean的方法。
 *      Full(proxyBeanMethods = true): 保持单实例
 *      Lite(proxyBeanMethods = false): 不保持单实例
 *      组件依赖
 * 4.@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件,默认组件的名字就是全类名
 * 5.@ImportResource("classpath:beans.xml")：导入Spring的配置文件
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
// @ConditionalOnBean(name = "tom") // 当有tom组件时，再注入容器下列的bean
@ConditionalOnMissingBean(name = "tom") // 当容器中没有tom组件时，注入下列的bean到容器中
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class) // 1.开启Car的属性配置功能。 2.把这个Car组件自动注册到容器中。
public class MyConfig {

    /**
     * 给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值就是组件在容器中的实例。
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象。
     * @return User
     */
    @ConditionalOnBean(name = "tom") // 当有tom组件时，再给容器注入user01
    @Bean
    public User user01(){
        User user = new User("张三", 18);
        // User组件依赖了Pet组件
        user.setPet(tomcatPet());
        return user;
    }

    // @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
