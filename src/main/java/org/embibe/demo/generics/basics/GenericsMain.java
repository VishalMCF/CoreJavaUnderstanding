package org.embibe.demo.generics.basics;

public class GenericsMain {

    public static void main(String[] args) {
        // demo for the use of object and how we can use it to refer to any datatype
        execute_use_case_where_object_reference_works_and_compile();

        //execute_use_case_where_object_reference_gives_runtime_exception(); -> ClassCasteException will happen

        execute_use_case_where_generics_allow_us_to_avoid_classCasteException_to_happen_at_the_runtime();
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

    /**
     * In the below method we are trying to typecast a double value to Integer value
     * Compiler allows us to execute the code but at runtime we get the ClassCasteException
     * For this to not happen Generics came into picture so that at the compiler time we can
     * prevent these errors to happen
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
     * I the below method we can see that how generics helps us to decrease the risks of having any ClassCasteException
     * Generics helps a class to restrict what type a data it can recieve at the compile time only saving us from
     * unexpected exceptions at the runtime.
     */
    private static void execute_use_case_where_generics_allow_us_to_avoid_classCasteException_to_happen_at_the_runtime(){
        WrapperGeneric<String> wrapperStringObject = new WrapperGeneric<>();
        wrapperStringObject.setData("Puss In Boots");

        // in the above code generics allow to restrict the type which the wrapperStringObject can receive
        // if we try to set the data inside the wrapper object with any value other than string compiler will show error
//        wrapperStringObject.setData(49);  --------------> uncommennt this to check if the error is shown or not

        String dataValue = wrapperStringObject.getData(); // we dont need to do any kind of typecasting
    }

}
