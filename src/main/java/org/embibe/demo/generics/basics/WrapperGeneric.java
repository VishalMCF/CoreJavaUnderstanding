package org.embibe.demo.generics.basics;

import lombok.Data;

@Data
public class WrapperGeneric <T>{
    private T data;
}
