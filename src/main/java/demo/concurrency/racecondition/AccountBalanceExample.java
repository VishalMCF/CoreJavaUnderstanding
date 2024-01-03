package org.embibe.demo.concurrency.racecondition;

/**
 * The following class demonstrates the race condition concept.
 * Race condition is a synchronisation problem where multiple threads gets to execute
 * a piece a code which can result into unpredictable outcomes different from if executed in a single thread
 * There is a balance update method where the account is modified by adding 10 rupees and then in the next line decreasing 10 rupees
 * But that method will be accessed and executed by two different threads at the runtime.
 * There will be two Threads which will be modifying the balancee
 */
public class AccountBalanceExample {

    static class Account {
        private int bankBalance = 100;

        public Account(int bankBalance) {
            this.bankBalance = bankBalance;
        }

        public void modifyBalance(){
            this.bankBalance += 10;
            this.bankBalance -= 10;
        }
    }

    public static void main(String[] args) {
//        Thread t1 = new Thread(()-{});
//        Thread t2 = new Thread(()-{});
    }


}
