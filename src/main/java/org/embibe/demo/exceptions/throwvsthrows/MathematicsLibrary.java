package org.embibe.demo.exceptions.throwvsthrows;

import java.io.IOException;

public class MathematicsLibrary {

    public MathematicsLibrary() {
    }

    public int divide(int a , int b) throws ArithmeticException {

            return a/b;
        
    }

    public int add(int a, int b) throws IOException {
        try {
            return a+b;
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
