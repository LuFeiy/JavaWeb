package _3module.concurrency;

import lombok.Data;
import org.junit.Test;

@Data
class Account {
    private String accountNo;
    private double balance;

    public Account(String accountNo, int initialBalance) {
        this.accountNo = accountNo;
        this.balance = initialBalance;
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("取钱成功! 吐出钞票：" + amount);
        } else {
            System.out.println("取钱失败! 余额不足");
        }
    }
}

class DrawTread_1 extends Thread {
    private Account account;
    private double drawAmount;

    public DrawTread_1(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }


    @Override
    public void run() {
        if (account.getBalance() >= drawAmount) {
            System.out.println(getName()+"取钱成功! 吐出钞票：" + drawAmount);
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println("余额: " + account.getBalance());
        }else {
            System.out.println("取钱失败! 余额不足");
        }
    }

}

class DrawTread_2 extends Thread {
    private Account account;
    private double drawAmount;

    public DrawTread_2(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //加上同步监视器
    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName()+"取钱成功! 吐出钞票：" + drawAmount);
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("余额: " + account.getBalance());
            }else {
                System.out.println("取钱失败! 余额不足");
            }
        }
    }
}

class DrawTread_3 extends Thread {
    private Account account;
    private double drawAmount;

    public DrawTread_3(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.withdraw(drawAmount);
    }
}


public class ClassicTransferExample {

    @Test
    public void test_01(){
        Account acct = new Account("12345",1000);
        new DrawTread_1("A", acct, 800).start();
        new DrawTread_1("B", acct, 800).start();
    }

    @Test
    public void test_02(){
        Account acct = new Account("12345",1000);
        new DrawTread_2("A", acct, 800).start();
        new DrawTread_2("B", acct, 800).start();
    }

    @Test
    public void test_03(){
        Account acct = new Account("12345",1000);
        new DrawTread_3("A", acct, 800).start();
        new DrawTread_3("B", acct, 800).start();
    }


}
