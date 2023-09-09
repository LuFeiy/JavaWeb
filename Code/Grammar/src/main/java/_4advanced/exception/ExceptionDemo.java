package _4advanced.exception;

import org.junit.Test;

import java.io.*;

public class ExceptionDemo {


    //try catch finally的基本使用
    @Test
    public void test_01(){
        BufferedReader reader = null;
        try { //try中包含会触发异常的正常流程代码
            File file = new File("src/main/resources/a.txt");
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }//仅处理匹配的catch子句,派生类对象，可以匹配基类
        } catch (FileNotFoundException e) {
            System.out.println("File not found:"+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading"+e.getMessage());
        } finally {//子句总会执行,即使try中有return
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing"+e.getMessage());
            }
        }
    }

    // throw throws
    //用于抛出自定义的异常或已有的异常实例,表示有这个属性
    public void hello(String name) throws Exception {
        if (name.equals("xi te le")){
            // 用于在方法声明中指定方法可能抛出的异常类型,是一个动作
            throw new Exception("This is a bad guy");
        }else {
            System.out.println("hello: " + name);
        }
    }

    @Test
    public void test_02() {
        try {
            hello("lan lan");
            hello("xi te le");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //在try()括号中进行异常操作,可能是个语法糖
    @Test
    public void test_03() {
        try (FileReader fileReader = new FileReader("example.txt");
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading"+e.getMessage());
        }
    }
}
