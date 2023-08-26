package org.embibe.demo.dashboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GenericDTO <T,V> {
    private T id;
    private V data;

    public GenericDTO(T id, V data) {
        this.id = id;
        this.data = data;
    }

    public GenericDTO(){}
}
