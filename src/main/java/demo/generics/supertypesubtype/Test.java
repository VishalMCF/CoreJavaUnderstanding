package org.embibe.demo.generics.supertypesubtype;

import org.embibe.demo.generics.commons.Wrapper;
import org.embibe.demo.generics.commons.WrapperGeneric;

public class Test {

    public static void main(String[] args) {
        WrapperGeneric<String> stringWrapper = new WrapperGeneric<>("Hello");
        WrapperGeneric<Object> objectWrapper   = new WrapperGeneric<>(400);

        objectWrapper.setData("another object string");

        // objectWrapper = stringWrapper;  ---->  this is not allowed at the compiler time
    }

    public void execute_supertype_subtype_test(){

    }

}
