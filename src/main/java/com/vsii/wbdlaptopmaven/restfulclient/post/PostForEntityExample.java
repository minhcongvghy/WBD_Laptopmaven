package com.vsii.wbdlaptopmaven.restfulclient.post;

import com.vsii.wbdlaptopmaven.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostForEntityExample {

    static final String URL_CREATE_PRODUCT = "http://localhost:8080/product";

    public static void main(String[] args) {

        Product newProduct = new Product("mac11", "i7","8GB", (double) 30000, "new");

        RestTemplate restTemplate = new RestTemplate();

        // Dữ liệu đính kèm theo yêu cầu.
        HttpEntity<Product> requestBody = new HttpEntity<>(newProduct);

        // Gửi yêu cầu với phương thức POST.
        ResponseEntity<Product> result
                = restTemplate.postForEntity(URL_CREATE_PRODUCT, requestBody, Product.class);

        System.out.println("Status code:" + result.getStatusCode());

        // Code = 200.
        if (result.getStatusCode() == HttpStatus.CREATED) {
            Product e = result.getBody();
            System.out.println("(Client Side) Product Created: "+ e.getName());
        }

    }
}
