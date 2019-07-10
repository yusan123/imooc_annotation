package com.yu.anno;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2019/7/10.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Description {

    String value();
//    String name();
//    String desc();
//    int age() default 19;
}
