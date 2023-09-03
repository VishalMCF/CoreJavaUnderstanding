package org.embibe.demo.exceptions.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        execute_demo_for_try_with_resources_code();
    }

    /**
     * Try with Resources:-
     * Usually when we are reading and information from file or readig data from the netweork socket
     * We have to open and close resources through the OS
     * Java 7 came with a eat approach where initialization is done within the try block
     * and no need to explicitly close the resource in the finally block
     *  general syntax is like below:-
     *  try(){
     *
     *  }catch(){
     *
     *  }
     *  no need to add finally block to close the resources
     */

    public static void execute_demo_for_try_with_resources_code() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("reader.txt"))) {
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
