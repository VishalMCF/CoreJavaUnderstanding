package org.embibe.demo.leetcode.lfu;

import java.util.HashMap;
import java.util.Map;

import lombok.ToString;

class Node {

    int key;
    int value;
    Node prev;
    Node next;
    int freq;

    Node(int k, int v) {
        key = k;
        value = v;
    }

    @Override
    public String toString(){
        return "{k"+key+" v"+value+" f"+freq+"}";
    }

}

class Dll {

    Node head;
    Node tail;
    int size;

    Dll() {
    }

    void insertFront(Node node) {
        size++;
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    void remove(Node node) {
        size--;
        if (node == head) {
            Node nextNode = node.next;
            if (nextNode != null) {
                nextNode.prev = null;
            }
            head = nextNode;
            if(head == null){
                tail = null;
            }
            node.prev = null;
            node.next = null;
            return;
        }

        if (node == tail) {
            Node prevNode = node.prev;
            if (prevNode != null) {
                prevNode.next = null;
            }
            tail = prevNode;
            if(tail == null){
                head = null;
            }
            node.prev = null;
            node.next = null;
            return;
        }


        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

//    @Override
//    public String toString() {
//        Node curr = head;
//        StringBuilder sb = new StringBuilder("");
//        while (curr != null) {
//            sb.append("{k=" + curr.key + ",v=" + curr.value + ",f=" + curr.freq + "} -> ");
//        }
//        return sb.toString();
//    }
}

public class LFUCache {

    Map<Integer, Dll> dllMap;
    Map<Integer, Node> keyNodeMap;
    int size;
    int maxSize;
    int minFreq;


    public LFUCache(int capacity) {
        maxSize = capacity;
        dllMap = new HashMap<>();
        keyNodeMap = new HashMap<>();
        minFreq = 1;
    }

    private void updateDllMap(Node node) {
        // first find the dll for current node using freq

        Dll dll = dllMap.get(node.freq);
        dll.remove(node);
        if (node.freq == minFreq) {
            if (dll.size == 0) {
                // System.out.println("remove minFreq map");
                dllMap.remove(minFreq);
                minFreq++;
            }
        }
        int newFreq = ++node.freq;
        if (!dllMap.containsKey(newFreq)) {
            dllMap.put(newFreq, new Dll());
        }
        dllMap.get(newFreq).insertFront(node);
        System.out.println(dllMap);
    }

    public int get(int key) {
        // key does not exist
        Node node = keyNodeMap.get(key);
        if (node == null) {
            return -1;
        }
        updateDllMap(node);
//        System.out.println("dllMap -> ");
//        System.out.println(dllMap);
        return node.value;
    }

    public void put(int key, int value) {
        // if key exists
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateDllMap(node);
//            System.out.println("dllMap -> ");
//            System.out.println(dllMap);
            return;
        }

        // if key does nnot exsis
        // Case 1:- if size < maxSize
        // Case 2:- if size == maxSIze
        if (size < maxSize) {
            size++;
            Node node = new Node(key, value);
            keyNodeMap.put(key, node);
            minFreq = 1;
            node.freq = minFreq;
            if (dllMap.get(minFreq) == null) {
                dllMap.put(minFreq, new Dll());
            }
            Dll minFreqDll = dllMap.get(minFreq);
            minFreqDll.insertFront(node);
        } else {
            //   System.out.println("Size is full");

            //   System.out.println("minFreq => "+minFreq);
            Dll minFreqDll = dllMap.get(minFreq);
            keyNodeMap.remove(minFreqDll.tail.key);
            minFreqDll.remove(minFreqDll.tail);
            minFreq = 1;
            if (dllMap.get(minFreq) == null) {
                dllMap.put(minFreq, new Dll());
            }
            Node node = new Node(key, value);
            keyNodeMap.put(key, node);
            minFreqDll = dllMap.get(minFreq);
            minFreqDll.insertFront(node);
            node.freq = minFreq;
        }
//        System.out.println("dllMap -> ");
//        System.out.println(dllMap);
    }
}
