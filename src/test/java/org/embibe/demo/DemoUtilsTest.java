package org.embibe.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DemoUtilsTest {

    @Test
    void Test_equals_and_Not_equals(){
        // set up
        DemoUtils demoUtils = new DemoUtils();
        int expected = 6;
        // execute
        int actual = demoUtils.add(2,4);

        // assert
        Assertions.assertEquals(actual, expected, "2+4 must be equals to 6");
    }

}