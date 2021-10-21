package com.xz.parking.utils;

//@FunctionalInterface这个是java8的lambda表达式的注解类
@FunctionalInterface
public interface ColaBeanUtilsCallBack<S, T> {

    void callBack(S t, T s);
}