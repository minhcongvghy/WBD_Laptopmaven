package com.vsii.wbdlaptopmaven.restfulclient.get;

import java.util.Arrays;

import com.vsii.wbdlaptopmaven.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetPOJOWithHeaderExample {

    static final String URL_PRODUCT = "http://localhost:8080/product";

    public static void main(String[] args) {

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<Product[]>: To get result as Product[].
        HttpEntity<Product[]> entity = new HttpEntity<Product[]>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
        ResponseEntity<Product[]> response = restTemplate.exchange(URL_PRODUCT, //
                HttpMethod.GET, entity, Product[].class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            Product[] list = response.getBody();

            if (list != null) {
                for (Product e : list) {
                    System.out.println("Product: " + e.getId() + " - " + e.getName());
                }
            }
        }

    }

}
