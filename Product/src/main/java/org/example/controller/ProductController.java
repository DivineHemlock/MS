package org.example.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @GetMapping("/getCoupon/{ }")
    public ResponseEntity<String> getCoupon(@PathVariable("couponName") String couponName) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:9090/api/v1/discount/" + couponName, String.class);
        String res = responseEntity.getBody().toString();
        return new ResponseEntity(res, HttpStatus.OK);
    }
}
