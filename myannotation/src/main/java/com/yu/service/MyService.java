package com.yu.service;

import com.yu.anno.Description;
import com.yu.jdkAnnotation.Child;

/**
 * Created by Administrator on 2019/7/10.
 *
 *
 * 注解可以被继承，子类的注解可以覆盖父类的注解
 */
//@Description("i am anno in class")
public class MyService extends Child{

    @Description("i am in method")
    public void hello(){
        System.out.println("hello");
    }
}
