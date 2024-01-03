package org.embibe.demo.anonymousclass.basics;

import java.util.function.Consumer;

public class AnonymousClassDemo {




    public static void main(String[] args) {

    }

    /**
     * Mehtod 1 to use Interface:-
     *      * create Interface reference and assign a class object which is implementing that interfcae
     *      * That class file should be preset in the dependecy path or projct
     */
    public void execute_non_anonymous_class_usage_demo(){
        IMathematicsLib mathematicsLib = new MathematicsLib();
        int addAsnwer = mathematicsLib.addNumbers(3,6);
        int nultiplyAsnwer = mathematicsLib.multiplyNumbers(3,6);

        System.out.println(addAsnwer);
        System.out.println(nultiplyAsnwer);
    }

    /**
     * Method 2:- no need to create class just use the below syntax
     * where you use new operator against the interface definition
     */

    public void execute_anonymous_class_usage_demo(){

        IMathematicsLib mathematicsLib = new IMathematicsLib() {
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
                return a/b;
            }
        };

        System.out.println(mathematicsLib.addNumbers(3,6));
        System.out.println(mathematicsLib.multiplyNumbers(3,6));
    }

}
