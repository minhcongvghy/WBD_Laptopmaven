package com.vsii.wbdlaptopmaven.restfulclient.post;

import com.vsii.wbdlaptopmaven.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PostForObjectExample {

    static final String URL_CREATE_PRODUCT = "http://localhost:8080/product";

    public static void main(String[] args) {

        Product newProduct = new Product("dell", "i7","8GB", (double) 20000, "new");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
        headers.setContentType(MediaType.APPLICATION_XML);

        RestTemplate restTemplate = new RestTemplate();

        // Dữ liệu đính kèm theo yêu cầu.
        HttpEntity<Product> requestBody = new HttpEntity<>(newProduct, headers);

        // Gửi yêu cầu với phương thức POST.
        Product e = restTemplate.postForObject(URL_CREATE_PRODUCT, requestBody, Product.class);

        if (e != null && e.getId() != null) {

            System.out.println("Product created: " + e.getName());
        } else {
            System.out.println("Something error!");
        }

    }
}
