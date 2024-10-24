//package org.embibe.demo.concurrency.threadbasics.examples.filefinder;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Queue;
//import java.util.concurrent.ConcurrentLinkedQueue;
//
//public class ParallelFileSearchStrategy implements IFileSearchStrategy {
//
//    private final Queue<File> queue;
//    private final Map<File, Boolean> fileProcessedMap;
//
//    private final String initialPath;
//
//    private final String fileToSearch;
//
//    private Result result;
//
//    public ParallelFileSearchStrategy(String initialPath, String fileName) {
//        this.queue = new ConcurrentLinkedQueue<>();
//        this.fileProcessedMap = new HashMap<>();
//        this.fileToSearch = fileName;
//        this.initialPath = initialPath;
//    }
//
//    @Override
//    public Result searchFile() {
//        fillQueueWithDirectories(this.initialPath);
//        if(result.isFound()){
//            return result;
//        }
//        return null;
//    }
//
//    private void fillQueueWithDirectories(String initialFilePath){
//        int totalThreads = Runtime.getRuntime().availableProcessors();
//        File file = new File(initialFilePath);
//        this.queue.add(file);
//        while(this.queue.size() != totalThreads) {
//            File currentFile = this.queue.poll();
//            fileProcessedMap.put(file,true);
//            File[] contents = currentFile.listFiles();
//            if(contents!=null && contents.length > 0){
//                for(File childFile: contents){
//                    if(childFile.isFile() && childFile.getName().equals(this.fileToSearch)){
//                        this.result.setFound(true);
//                        this.result.setFoundPath(childFile.getPath());
//                        return;
//                    } else {
//                        this.queue.add(file);
//                    }
//                }
//            }
//        }
//    }
//}
