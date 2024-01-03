package org.embibe.demo.leetcode.lfu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> commands =
            Arrays.asList("LFUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put",
                "get", "get", "get", "get", "put", "put", "get");
        List<List<Integer>> values = Arrays.asList(
            Arrays.asList(10),
            Arrays.asList(10, 13),
            Arrays.asList(3, 17),
            Arrays.asList(6, 11),
            Arrays.asList(10, 5),
            Arrays.asList(9, 10),
            Arrays.asList(13),
            Arrays.asList(2, 19),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList(5, 25),
            Arrays.asList(8),
            Arrays.asList(9, 22),
            Arrays.asList(5, 5),
            Arrays.asList(1, 30),
            Arrays.asList(11),
            Arrays.asList(9, 12),
            Arrays.asList(7),
            Arrays.asList(5),
            Arrays.asList(8),
            Arrays.asList(9),
            Arrays.asList(4, 30),
            Arrays.asList(9, 9),
            Arrays.asList(9)
        );

        LFUCache lfuCache = null;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            List<Integer> value = values.get(i);

            if (command.equals("LFUCache")) {
                lfuCache = new LFUCache(value.get(0));
                result.add(null);
            } else if (command.equals("put")) {
                lfuCache.put(value.get(0), value.get(1));
                result.add(null);
            } else if (command.equals("get")) {
                int res = lfuCache.get(value.get(0));
                result.add(res);
            }
        }

        System.out.println(result);
    }
}
