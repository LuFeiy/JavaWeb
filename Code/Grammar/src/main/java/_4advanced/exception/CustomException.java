package _4advanced.exception;

import org.junit.Test;

public class CustomException {

    //自定义异常就是继承
    class MyCustomException extends Exception{
        public MyCustomException(String msg) {
            super(msg);
        }
    }

    @Test
    public void test_01(){
        try {
            throw new MyCustomException("this is my CustomException");
        } catch (Exception e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}
