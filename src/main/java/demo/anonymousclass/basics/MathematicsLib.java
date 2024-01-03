package org.embibe.demo.anonymousclass.basics;

public class MathematicsLib implements IMathematicsLib{

    @Override
    public int addNumbers(int a, int b) {
        return a+b;
    }

    @Override
    public int multiplyNumbers(int a, int b) {
        return a*b;
    }

    @Override
    public int divideNumbers(int a, int b) {
        if(b==0){
            throw new ArithmeticException("0 is in divisor");
        }
        return a/b;
    }
}
