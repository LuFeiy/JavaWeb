package _3module.concurrency;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//继承Thread类来创建线程,调用start
class MyThread_1 extends Thread {
    @Override
    public void run() {
        System.out.println("In MyThread_1");
    }
}

//实现Runnable接口,调用run,获取传给Thread
class MyRunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println("In MyRunnableImpl");
    }
}

//使用Callable并用FutureTask来创建有返回值的线程
class MyCallable implements Callable<String > {
    @Override
    public String call() throws Exception {
        return "wang zhong lan";
    }
}




public class ThreadCreateDemo {

    @Test
    public void test_01(){
        MyThread_1 myTread = new MyThread_1();
        myTread.start();
    }

    @Test
    public void test_02(){
        //使用run
        new MyRunnableImpl().run();

        //传递给Thread
        new Thread(new MyRunnableImpl()).start();

        //使用匿名类
        new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Anonymous Class");
            }
        }.run();
        //使用lambda
        new Thread(() -> {
            // 线程要执行的代码逻辑
            System.out.println("Thead lambda");
        }).start();
    }

    @Test
    public void test_03() throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);

        Thread thread = new Thread(futureTask);
        thread.start();

        //获取线程执行结果
        String result = futureTask.get();
        System.out.println("Thread result:" + result);
    }




}
