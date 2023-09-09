package com.yuan.spring.aop;

import org.junit.jupiter.api.Test;

public class ProxyFactoryTest {

    @Test
    public void test_01(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1, 2);
    }

}
