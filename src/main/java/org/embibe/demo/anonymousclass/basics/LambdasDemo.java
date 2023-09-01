package org.embibe.demo.anonymousclass.basics;

public class LambdasDemo {

    public static void main(String[] args) {
        single_abstract_lambda_function_usage_demo();
    }

    public static void single_abstract_anonymous_class_usage_demo(){
        IComplexNumberModulus complexNumberModulus = new IComplexNumberModulus() {
            @Override
            public int modulus(ComplexNumber c) {
                return (int)Math.sqrt(Math.pow((double)c.getImaginaryNumber(),2.0)+Math.pow((double)c.getRealNumber(),2.0));
            }
        };

        System.out.println(complexNumberModulus.modulus(new ComplexNumber<>(3.0,4.0)));
    }

    public static void single_abstract_lambda_function_usage_demo() {
        IComplexNumberModulus complexNumberModulus = c ->
            (int) Math.sqrt(Math.pow( c.getRealNumber(),2) + Math.pow( c.getImaginaryNumber(),2));
        System.out.println(complexNumberModulus.modulus(new ComplexNumber<>(3.0,4.0)));
    }

    // consumer -> (input) -> {
    // }

}
