package org.embibe.demo.concurrency.threadbasics.examples.filefinder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Result {

    private String foundPath;
    private boolean found;
}
