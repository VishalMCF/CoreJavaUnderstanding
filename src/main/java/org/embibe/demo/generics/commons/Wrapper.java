package org.embibe.demo.generics.commons;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * How do you create a generic class which will work for multiple types so that we dont have to rely on Object class
 * The reason we use generics is to avoid ClassCasteException at the runtime.
 * Generics allows us to check any code error related to type compatibility at the compile time only
 * 2 examples are present in the basics package
 */

@Data
@AllArgsConstructor
public class Wrapper {

    private Object data;

}
