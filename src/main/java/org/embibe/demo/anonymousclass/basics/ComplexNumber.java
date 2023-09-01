package org.embibe.demo.anonymousclass.basics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplexNumber<T extends Double> {

    private T realNumber;
    private T imaginaryNumber;

}
