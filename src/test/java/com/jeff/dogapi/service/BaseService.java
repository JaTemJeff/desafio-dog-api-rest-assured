package com.jeff.dogapi.service;

import com.jeff.dogapi.client.DogApiClient;

public class BaseService {
    protected final DogApiClient dogApiClient = new DogApiClient();
}
