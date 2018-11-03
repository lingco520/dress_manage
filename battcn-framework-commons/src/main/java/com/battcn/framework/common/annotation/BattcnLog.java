package com.battcn.framework.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 拦截Controller
 *
 * @author Levin
 * @since 2018-01-10
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BattcnLog {

    /**
     * 模块名称 系统管理-用户管理－列表页面
     *
     * @return 模块名称
     */
    String module() default "";

    /**
     * 新增用户
     *
     * @return 方法名
     */
    String methods() default "";

    /**
     * 描述
     *
     * @return 描述信息
     */
    String description() default "";

}
