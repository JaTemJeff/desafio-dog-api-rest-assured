package com.jeff.dogapi.services;

import com.jeff.dogapi.client.DogApiClient;

public class BaseService {
    protected final DogApiClient dogApiClient = new DogApiClient();
}
