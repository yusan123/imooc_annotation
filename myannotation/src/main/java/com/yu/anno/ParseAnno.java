package com.yu.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/7/10.
 */
public class ParseAnno {

    public static void main(String[] args) {

        try {
            Class<?> c = Class.forName("com.yu.service.MyService");
            boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist){
                Description annotation = c.getAnnotation(Description.class);
                System.out.println(annotation.value());
            }

            //获取所有方法
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                boolean isMethodExist = method.isAnnotationPresent(Description.class);
                if (isMethodExist){
                    Description annotation = method.getAnnotation(Description.class);
                    System.out.println(annotation.value());
                }

            }

            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Description){
                        Description desc = (Description) annotation;
                        System.out.println(desc.value());
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
