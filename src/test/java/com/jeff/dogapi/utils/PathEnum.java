package com.jeff.dogapi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PathEnum {
    GET_ALL_BREEDS("/breeds/list/all"),
    GET_BY_BREEDS("/breed/hound/images"),
    GET_RANDOM_IMAGE("/breeds/image/random");
    private final String path;
}
