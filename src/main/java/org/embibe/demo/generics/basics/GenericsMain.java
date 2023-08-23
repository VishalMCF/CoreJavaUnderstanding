package org.embibe.demo.generics.basics;

public class GenericsMain {

    public static void main(String[] args) {
        // demo for the use of object and how we can use it to refer to any datatype
        execute_use_case_where_object_reference_works_and_compile();
        execute_use_case_where_object_reference_gives_runtime_exception();
    }

    /**
     *
     */
    private static void execute_use_case_where_object_reference_gives_runtime_exception() {
        Wrapper wrapperObject = new Wrapper(29);
        System.out.println(wrapperObject.getData());
        wrapperObject.setData("hello world");
        System.out.println(wrapperObject.getData());
        wrapperObject.setData(49.9);
        System.out.println(wrapperObject.getData());

        // !!  Alert !! -> This will throw ClassCasteException depite it gets compiled
        Integer itemFromWrapper = (Integer) wrapperObject.getData();
    }


    /**
     * In the below code we created a wrapper object and we are able to see that we can set any type of data.
     * Its possible only because of the reference we are using to capture the data inside the Wrapper object.
     * We are using reference of object type. And it can refer to any type of object and the compiler allows
     * the code to compile.
     */
    public static void execute_use_case_where_object_reference_works_and_compile(){
        Wrapper wrapperObject = new Wrapper(29);
        System.out.println(wrapperObject.getData());
        wrapperObject.setData("hello world");
        System.out.println(wrapperObject.getData());
        wrapperObject.setData(49.9);
        System.out.println(wrapperObject.getData());
    }

}
