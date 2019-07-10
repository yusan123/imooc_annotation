package com.yu.jdkAnnotation;

/**
 * Created by Administrator on 2019/7/10.
 *
 *
 * jdk中有三个注解
 * @Override 用于子类重写父类方法
 * @Deprecated 用于标示弃用的方法或类
 * @SuppressWarnings 用于压制警告
 *
 */
public class NewChild extends Child {
    @Override
    public void eat() {
        super.eat();
    }

    @Override
    @Deprecated
    public void hunting() {
        super.hunting();
    }



    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        NewChild newChild = new NewChild();

        newChild.eat();
        newChild.hunting();
    }
}
