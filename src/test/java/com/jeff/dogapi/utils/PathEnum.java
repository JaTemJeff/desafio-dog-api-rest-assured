package com.jeff.dogapi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PathEnum {
    GET_ALL_BREEDS("/breeds/list/all");
    private final String path;
}
