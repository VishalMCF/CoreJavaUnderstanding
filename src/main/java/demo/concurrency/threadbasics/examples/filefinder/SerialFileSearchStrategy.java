//package org.embibe.demo.concurrency.threadbasics.examples.filefinder;
//
//import java.io.File;
//
//public class SerialFileSearchStrategy implements IFileSearchStrategy {
//
//    private String initialPath;
//    private String fileName;
//
//    public SerialFileSearchStrategy(String initialPath, String fileName) {
//        this.initialPath = initialPath;
//        this.fileName = fileName;
//    }
//
//    private void executeSearchFile(Result result, File currentDirectory) {
//        File[] contents = currentDirectory.listFiles();
//        if(contents != null) {
//            for (File file : contents) {
//                if (file.isDirectory()) {
//                    executeSearchFile(result, file);
//                    if(result.isFound()){
//                        return;
//                    }
//                } else if (file.isFile() && file.getName().equals(fileName)) {
//                    result.setFound(true);
//                    result.setFoundPath(file.getAbsolutePath());
//                    return;
//                }
//            }
//        }
//    }
//
//    public Result searchFile() {
//        Result result = new Result();
//        File initialFilePath = new File(initialPath);
//        executeSearchFile(result, initialFilePath);
//        return result;
//    }
//}