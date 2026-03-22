package com.jeff.dogapi.service;

import com.jeff.dogapi.utils.PathEnum;
import io.restassured.response.Response;

public class BreedsService extends BaseService {

    public Response listAllBreeds() {
        return dogApiClient.get(PathEnum.GET_ALL_BREEDS.getPath());
    }
}
