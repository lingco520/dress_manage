package com.battcn.platform;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序启动类
 *
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan("com.battcn.platform")
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        SpringContextUtil.setApplicationContext(context);
    }

    static public class SpringContextUtil {

        private static ApplicationContext applicationContext;

        public static ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        private static void setApplicationContext(ApplicationContext applicationContext) {
            SpringContextUtil.applicationContext = applicationContext;
        }

        public static Object getBean(String name) {
            return applicationContext.getBean(name);
        }

        public static <T> T getBean(Class<T> requiredType) {
            return applicationContext.getBean(requiredType);
        }
    }

}
