package com.vsii.wbdlaptopmaven.restfulclient.get;

import org.springframework.web.client.RestTemplate;

public class SimplestGetExample {

    static final String URL_PRODUCT = "http://localhost:8080/product";

    static final String URL_PRODUCT_XML = "http://localhost:8080/product.xml";
    static final String URL_PRODUCT_JSON = "http://localhost:8080/product.json";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // Gửi yêu cầu với phương thức GET và Headers mặc định.
        String result = restTemplate.getForObject(URL_PRODUCT, String.class);

        System.out.println(result);
    }

}
