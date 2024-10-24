//package org.embibe.demo.concurrency.threadbasics.examples.filefinder;
//
//import java.io.File;
//
//public class FileFinderTest {
//
//    public static void main(String[] args) {
//        execute_serial_file_search_test();
//    }
//
//    /**
//     * uses a recursion based serial version of file search
//     * using java.io File package
//     */
//    private static void execute_serial_file_search_test(){
//        String initialFilePath = "/Users/vishalyadav/Desktop/projects";
//        String fileToSearch = "LoginWidget.jsx";
//        File file = new File(initialFilePath);
//        if(file.isDirectory()){
//            IFileSearchStrategy fileSearchStrategy = new SerialFileSearchStrategy(initialFilePath, fileToSearch);
//            Result result = fileSearchStrategy.searchFile();
//            System.out.println(result);
//        }
//    }
//
//    /**
//     * The following method demonstrates the parallel version of the file search
//     * We will be keeping a queue which will store the reference to the file paths
//     * which needs to explored independently to search a file.
//     * From the queue one path will be picked up by a thread and that thread will explore the directory
//     * using recursion based tactics to search for the file.
//     * If any thread has found the file then all the threads needs to be interrupted so that the processing can be stopped.
//     */
//    private static void parallel_file_search_test(){
//
//    }
//
//}
