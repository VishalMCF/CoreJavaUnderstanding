package org.embibe.demo.exceptions.throwvsthrows;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        execute_throws_demo_code_for_unchecked_exceptions();
        execute_throws_demo_code_for_checked_exceptions();
    }

    /**
     * In the below code demo the method 'divide' of lib class is being accessed.
     * But in the divide method if you see we have mention that it throws ArithmaticException
     * Because ArithmeticException class belongs to the category of unchecked exceptions
     * the compiler wont force you to handle it in the client code as can be seen below
     */
    public static void execute_throws_demo_code_for_unchecked_exceptions(){
        MathematicsLibrary lib = new MathematicsLibrary();
        System.out.println(lib.divide(4,5));
    }

    /**
     * In the below code demo the method 'add' of lib class is being accessed.
     * But in the add method if you see we have mention that it throws IOException
     * Because IOException class belongs to the category of checked exceptions
     * the compiler forces you to handle it in the client code mode using either try-catch block
     * or by using throws keyword in the client method itself
     */

    public static void execute_throws_demo_code_for_checked_exceptions(){
        MathematicsLibrary lib = new MathematicsLibrary();
        try {
            System.out.println(lib.add(4,5));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
