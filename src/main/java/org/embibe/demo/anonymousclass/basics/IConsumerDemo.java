package org.embibe.demo.anonymousclass.basics;

@FunctionalInterface
public interface IConsumerDemo<T> {

    public void operate(T input);

}

